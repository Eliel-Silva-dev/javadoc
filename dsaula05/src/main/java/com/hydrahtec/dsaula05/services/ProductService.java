package com.hydrahtec.dsaula05.services;

import com.hydrahtec.dsaula05.entities.ProductEntity;
import com.hydrahtec.dsaula05.exceptions.CategoryNotFoundException;
import com.hydrahtec.dsaula05.exceptions.ProductNotFoundException;
import com.hydrahtec.dsaula05.models.ProductDto;
import com.hydrahtec.dsaula05.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<ProductEntity> product = productRepository.findById(id);

        if (product.isPresent()) {
            return new ProductDto(
                    product.get().getName(),
                    product.get().getPrice(),
                    product.get().getCategory().getId());
        } else {
            throw new ProductNotFoundException("product not found");
        }
    }
}
