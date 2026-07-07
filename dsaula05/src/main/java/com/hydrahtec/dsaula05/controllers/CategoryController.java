package com.hydrahtec.dsaula05.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/caegories")
public class CategoryController {
    @GetMapping
    public ResponseEntity<> findAll() {

        return ResponseEntity.status(HttpStatus.OK).body();
    }
}
