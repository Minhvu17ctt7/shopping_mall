package com.example.shoppingmall.controller.admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import com.example.shoppingmall.domain.Category;
import com.example.shoppingmall.model.CategoryDto;
import com.example.shoppingmall.service.CategoryService;
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
@RequestMapping("admin/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    @RequestMapping("")
    public String list(Model model) {
        List<Category> list = categoryService.findAll();
        model.addAttribute("categories", list);
        return "/admin/categories/list";
    }
    @GetMapping("/add")
    private String add(Model model) {
        model.addAttribute("category", new CategoryDto());
        return "admin/categories/addOrEdit";
    }

    @GetMapping("edit/{categoryId}")
    public ModelAndView edit(ModelMap model, @PathVariable(name = "categoryId") Long categoryId) {
        Optional<Category> opt = categoryService.findById(categoryId);
        if(opt.isPresent()) {
            Category category = opt.get();
            CategoryDto categoryDto = new CategoryDto();
            BeanUtils.copyProperties(category,categoryDto);
            categoryDto.setIsEdit(true);
            model.addAttribute("category",categoryDto);
            return new ModelAndView("admin/categories/addOrEdit",model);
        }
        model.addAttribute("message","Category is not existed ");
        return new ModelAndView("forward:/admin/categories",model);
    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model,
                                     @Valid @ModelAttribute("category") CategoryDto dto, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView("admin/categories/addOrEdit");
        }
        Category entity = new Category();
        BeanUtils.copyProperties(dto,entity);


        categoryService.save(entity);
        model.addAttribute("message","Category is saved");
        return new ModelAndView("forward:/admin/categories/",model);
    }

    @GetMapping("delete/{categoryId}")
    public ModelAndView delete(ModelMap model, @PathVariable("categoryId") Long id) {
        categoryService.deleteById(id);
        model.addAttribute("message","Category is deleted");
        return new ModelAndView("forward:/admin/categories",model);
    }

    @GetMapping("search")
    public String search(Model model, @RequestParam(name="name", required = false) String name) {
        List<Category> list = null;
        if(StringUtils.hasText(name)) {
            list = categoryService.findByNameContaining(name);
        }else {
            list = categoryService.findAll();
        }
        model.addAttribute("categories",list);
        return "admin/categories/search";
    }

    @GetMapping("searchpaginated")
    public String search(Model model, @RequestParam(name = "name", required = false) String name,
                         @RequestParam("page") Optional<Integer> page,
                         @RequestParam("size") Optional<Integer> size) {
        List<Category> list = null;
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage - 1,pageSize, Sort.by("name"));
        Page<Category> resultPage = null;
        if(StringUtils.hasText(name)) {
            resultPage = categoryService.findByNameContaining(name,pageable);
            model.addAttribute("name",name);
        }else {
            resultPage = categoryService.findAll(pageable);
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
        model.addAttribute("categoryPage",  resultPage);
        return "admin/categories/searchpaginated";
    }

}
