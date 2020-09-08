package com.wath.amsui.controller;

import com.wath.amsui.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.ExecutionException;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("categories")
    public String categories(ModelMap map){

        map.addAttribute("category",categoryService.getCategories().getData());

        return "category";
    }

    @GetMapping("categories/{id}")
    public String categories(@PathVariable int id,ModelMap map){
        try {
            map.addAttribute("category",categoryService.getCategoryByID(id).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return "category";
    }

}
