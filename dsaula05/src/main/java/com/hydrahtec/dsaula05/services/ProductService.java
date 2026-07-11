package com.hydrahtec.dsaula05.services;

import com.hydrahtec.dsaula05.exceptions.ProductNotFoundException;
import com.hydrahtec.dsaula05.models.ProductDto;
import com.hydrahtec.dsaula05.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> findAllProduct() {
        return productRepository.findAll().stream()
                .map(entity -> new ProductDto(
                        entity.getName(),
                        entity.getPrice(),
                        entity.getCategory() != null ? entity.getCategory().getId() : null
                )).toList();
    }

    public ProductDto findProductById(Long id) {
        return productRepository.findById(id)
                .map(entity -> new ProductDto(
                        entity.getName(),
                        entity.getPrice(),
                        entity.getCategory() != null ? entity.getCategory().getId() : null))
                .orElseThrow(() -> new ProductNotFoundException("product not found"));
    }
}
