package com.raysi.blogmanagementsystem.controllers;

import com.raysi.blogmanagementsystem.entities.Category;
import com.raysi.blogmanagementsystem.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/api/category")
    public List<Category> getAllCat(){
        return categoryService.getAllCategory();
    }

    @PostMapping("/api/category")
    public String postCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return """
                Your category subbmitted successfullt !
                """;
    }

}
