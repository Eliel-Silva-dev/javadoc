package com.hydrahtec.dsaula05.controllers;

import com.hydrahtec.dsaula05.models.CategoryDto;
import com.hydrahtec.dsaula05.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDto> findAll() {
        return categoryService.findAllCategories();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDto findById(@PathVariable Long id) {
        return categoryService.findCategoryById(id);
    }
}
