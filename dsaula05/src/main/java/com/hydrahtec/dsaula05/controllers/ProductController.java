package com.hydrahtec.dsaula05.controllers;

import com.hydrahtec.dsaula05.models.ProductDto;
import com.hydrahtec.dsaula05.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> findAll() {
        return productService.findAllProduct();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto findById(@PathVariable Long id) {
        return productService.findProductById(id);
    }
}
