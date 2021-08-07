package com.example.shoppingmall.controller.admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import com.example.shoppingmall.domain.Brand;
import com.example.shoppingmall.model.BrandDto;
import com.example.shoppingmall.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("admin/brands")
@AllArgsConstructor
public class BrandController {

    private final BrandService brandService;
    @RequestMapping("")
    public String list(Model model) {
        List<Brand> list = brandService.findAll();
        model.addAttribute("brands", list);
        return "/admin/brands/list";
    }
    @GetMapping("/add")
    private String add(Model model) {
        model.addAttribute("brand", new BrandDto());
        return "admin/brands/addOrEdit";
    }

    @GetMapping("edit/{brandId}")
    public ModelAndView edit(ModelMap model, @PathVariable(name = "brandId") Long brandId) {
        Optional<Brand> opt = brandService.findById(brandId);
        if(opt.isPresent()) {
            Brand brand = opt.get();
            BrandDto brandDto = new BrandDto();
            BeanUtils.copyProperties(brand,brandDto);
            brandDto.setIsEdit(true);
            model.addAttribute("brand",brandDto);
            return new ModelAndView("admin/brands/addOrEdit",model);
        }
        model.addAttribute("message","Brand is not existed ");
        return new ModelAndView("forward:/admin/brands",model);
    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model,
                                     @Valid @ModelAttribute("brand") BrandDto dto, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView("admin/brands/addOrEdit");
        }
        Brand entity = new Brand();
        BeanUtils.copyProperties(dto,entity);


        brandService.save(entity);
        model.addAttribute("message","Brand is saved");
        return new ModelAndView("forward:/admin/brands/",model);
    }

    @GetMapping("delete/{brandId}")
    public ModelAndView delete(ModelMap model, @PathVariable("brandId") Long id) {
        brandService.deleteById(id);
        model.addAttribute("message","Brand is deleted");
        return new ModelAndView("forward:/admin/brands",model);
    }

    @GetMapping("search")
    public String search(Model model, @RequestParam(name="name", required = false) String name) {
        List<Brand> list = null;
        if(StringUtils.hasText(name)) {
            list = brandService.findByNameContaining(name);
        }else {
            list = brandService.findAll();
        }
        model.addAttribute("brands",list);
        return "admin/brands/search";
    }

    @GetMapping("searchpaginated")
    public String search(Model model, @RequestParam(name = "name", required = false) String name,
                         @RequestParam("page") Optional<Integer> page,
                         @RequestParam("size") Optional<Integer> size) {
        List<Brand> list = null;
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage - 1,pageSize, Sort.by("name"));
        Page<Brand> resultPage = null;
        if(StringUtils.hasText(name)) {
            resultPage = brandService.findByNameContaining(name,pageable);
            model.addAttribute("name",name);
        }else {
            resultPage = brandService.findAll(pageable);
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
        model.addAttribute("brandPage",  resultPage);
        return "admin/brands/searchpaginated";
    }

}
