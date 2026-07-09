package com.hydrahtec.dsaula05.controllers;

import com.hydrahtec.dsaula05.exceptions.CategoryNotFoundException;
import com.hydrahtec.dsaula05.entities.CategoryEntity;
import com.hydrahtec.dsaula05.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<CategoryEntity>> findAll() {
        List<CategoryEntity> categories = new ArrayList<>();
        categories.add(new CategoryEntity(1L, "Eletronics"));
        categories.add(new CategoryEntity(2L, "Books"));

        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryEntity> findById(@PathVariable Long id) {

        CategoryEntity category = new CategoryEntity();

        try {
            if(id == 1) {
                category.setId(1L);
                category.setName("Eletronics");

                return ResponseEntity.status(HttpStatus.OK).body(category);
            } else {
                throw new CategoryNotFoundException("Categoria inezistente");
            }
        } catch (CategoryNotFoundException ex) {
            category.setId(null);
            category.setName(null);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(category);
        }
    }
}
