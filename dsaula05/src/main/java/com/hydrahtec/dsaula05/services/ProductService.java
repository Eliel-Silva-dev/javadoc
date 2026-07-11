package com.hydrahtec.dsaula05.services;

import com.hydrahtec.dsaula05.entities.ProductEntity;
import com.hydrahtec.dsaula05.exceptions.CategoryNotFoundException;
import com.hydrahtec.dsaula05.models.ProductDto;
import com.hydrahtec.dsaula05.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private static final Logger log = LoggerFactory.getLogger(CategoryService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> findAllProduct() {
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();

        for (int i = 0; i < productEntities.size(); i++) {
            ProductDto product = new ProductDto(productEntities.get(i).getName(),
                    productEntities.get(i).getPrice(),
                    productEntities.get(i).getCategory().getId());

            productDtos.add(product);
        }

        return productDtos;
    }

    public ProductDto findProductById(Long id) {
        Optional<ProductEntity> category = productRepository.findById(id);

        if (category.isPresent()) {
            return new ProductDto(category.get().getName(), category.get().getPrice(),
                    category.get().getCategory().getId());
        } else {
            throw new CategoryNotFoundException("Category not found");
        }
    }
}
