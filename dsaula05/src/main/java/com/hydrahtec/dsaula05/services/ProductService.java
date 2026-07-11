package com.hydrahtec.dsaula05.services;

import com.hydrahtec.dsaula05.entities.ProductEntity;
import com.hydrahtec.dsaula05.exceptions.CategoryNotFoundException;
import com.hydrahtec.dsaula05.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> findAllRepository() {
        return productRepository.findAll();
    }

    public ProductEntity findRepositoryById(Long id) {
        Optional<ProductEntity> category = productRepository.findById(id);

        if (category.isPresent()) {
            return category.get();
        } else {
            throw new CategoryNotFoundException("Category not found");
        }
    }
}
