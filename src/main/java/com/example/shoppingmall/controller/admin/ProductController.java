package com.example.shoppingmall.controller.admin;

import com.example.shoppingmall.domain.Brand;
import com.example.shoppingmall.domain.ImageProduct;
import com.example.shoppingmall.domain.Product;
import com.example.shoppingmall.model.BrandDto;
import com.example.shoppingmall.model.ImageProductDto;
import com.example.shoppingmall.model.ProductDto;
import com.example.shoppingmall.service.*;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import com.example.shoppingmall.domain.Category;
import com.example.shoppingmall.model.CategoryDto;
import com.example.shoppingmall.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("admin/products")
@AllArgsConstructor
public class ProductController {

    private final CategoryService categoryService;
    private final BrandService brandService;
    private final ProductService productService;
    private final StorageService storageService;
    private final ImageProductService imageProductService;

    @ModelAttribute("categories")
    public List<CategoryDto> getCategory() {
        return categoryService.findAll().stream().map(item -> {
            CategoryDto dto = new CategoryDto();
            BeanUtils.copyProperties(item,dto);
            return dto;
        }).collect(Collectors.toList());
    }
    @ModelAttribute("brands")
    public List<BrandDto> getBrand() {
        return brandService.findAll().stream().map(item -> {
            BrandDto dto = new BrandDto();
            BeanUtils.copyProperties(item,dto);
            return dto;
        }).collect(Collectors.toList());
    }
    @RequestMapping("")
    public String list(Model model) {
        List<Product> list = productService.findAll();
        model.addAttribute("products", list);
        return "/admin/products/list";
    }
    @GetMapping("/add")
    private String add(Model model) {
        model.addAttribute("product", new ProductDto());
        return "admin/products/addOrEdit";
    }
    @GetMapping("/images/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable("filename") String fileName) {
        storageService.setRootLocation(Paths.get("uploads/images/products/"));
        Resource file = storageService.loadAsResource(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" +file.getFilename() +
                "\"").body(file);
    }

    @GetMapping("edit/{productId}")
    public ModelAndView edit(ModelMap model, @PathVariable(name = "productId") Long productId) {
        Optional<Product> opt = productService.findById(productId);
        if(opt.isPresent()) {
            Product product = opt.get();
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            productDto.setIsEdit(true);
            //set brabd id and categoryid
            productDto.setBrandId(product.getBrand().getBrandId());
            productDto.setCategoryId(product.getCategory().getCategoryId());

            model.addAttribute("product",productDto);
            return new ModelAndView("admin/products/addOrEdit",model);
        }
        model.addAttribute("message","Product is not existed ");
        return new ModelAndView("forward:/admin/products",model);
    }

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(
                                     @Valid @ModelAttribute("product") ProductDto productDto, BindingResult result) throws IOException {
        if(result.hasErrors()) {
            return "admin/categories/addOrEdit";
        }


        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);

        Category category = new Category();
        category.setCategoryId(productDto.getCategoryId());
        product.setCategory(category);
        Brand brand = new Brand();
        brand.setBrandId(productDto.getBrandId());
        product.setBrand(brand);

        storageService.setRootLocation(Paths.get("uploads/images/products/"));
        if(productDto.getIsEdit()) {
            Optional<Product> opt = productService.findById(productDto.getProductId());
            Product oldProduct = opt.get();
                if(!productDto.getImageFile().isEmpty()) {
                   storageService.store(productDto.getImageFile(), oldProduct.getImage());
                    product.setImage(oldProduct.getImage());
            }
        }
        else  {
            UUID uuid = UUID.randomUUID();
            String uuSTRING = uuid.toString();

            product.setImage(storageService.getStoredFilename(productDto.getImageFile(),uuSTRING));
            storageService.store(productDto.getImageFile(),product.getImage());
        }

        productService.save(product);

        return "redirect:/admin/products";
    }
    @GetMapping("delete/{productId}")
    public ModelAndView delete(ModelMap model, @PathVariable("productId") Long id) throws IOException {
        Optional<Product> opt = productService.findById(id);
        if(opt.isPresent()) {
            Product product = opt.get();

                storageService.setRootLocation(Paths.get("uploads/images/products/"));
                storageService.delete(product.getImage());



            productService.deleteById(id);
            model.addAttribute("message","Product is deleted");
        } else {
            model.addAttribute("message","Product not found");
        }
        return new ModelAndView("forward:/admin/products",model);
    }

    @GetMapping("search")
    public String search(Model model, @RequestParam(name="title", required = false) String title) {
        List<Product> list = null;
        if(StringUtils.hasText(title)) {
            list = productService.findByTitleContaining(title);
        }else {
            list = productService.findAll();
        }
        model.addAttribute("products",list);
        return "admin/products/search";
    }

    @GetMapping("searchpaginated")
    public String search(Model model, @RequestParam(name = "title", required = false) String title,
                         @RequestParam("page") Optional<Integer> page,
                         @RequestParam("size") Optional<Integer> size) {
        List<Product> list = null;
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage - 1,pageSize, Sort.by("name"));
        Page<Product> resultPage = null;
        if(StringUtils.hasText(title)) {
            resultPage = productService.findByTitleContaining(title,pageable);
            model.addAttribute("name",title);
        }else {
            resultPage = productService.findAll(pageable);
        }

        int totalPages = resultPage.getTotalPages();
        if(totalPages > 0) {
            int start = Math.max(1,currentPage-2);
            int end = Math.min(currentPage + 2, totalPages);

            if(totalPages > 5)  {
                if(end == totalPages) start = end - 5;
                else if(start == 1) end = start + 5;
            }

            List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("productPage",  resultPage);
        return "admin/products/searchpaginated";
    }

}
