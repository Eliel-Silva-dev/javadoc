package com.hydrahtec.dsaula05.controllers;

import entities.CategoryEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    @GetMapping
    public ResponseEntity<List<CategoryEntity>> findAll() {
        List<CategoryEntity> categories = new ArrayList<>();
        categories.add(new CategoryEntity(1L, "Eletronics"));
        categories.add(new CategoryEntity(2L, "Books"));

        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<> findById(@RequestParam Long id) {
//
//
//        return ResponseEntity.status(HttpStatus.OK).body();
//    }
}
