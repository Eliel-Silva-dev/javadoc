package com.hydrahtec.dsaula05.services;

import com.hydrahtec.dsaula05.entities.CategoryEntity;
import com.hydrahtec.dsaula05.entities.ProductEntity;
import com.hydrahtec.dsaula05.exceptions.CategoryNotFoundException;
import com.hydrahtec.dsaula05.exceptions.ProductNotFoundException;
import com.hydrahtec.dsaula05.models.ProductDto;
import com.hydrahtec.dsaula05.repositories.CategoryRepository;
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
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductDto> findAllProduct() {
        log.info("Find all products");
        return productRepository.findAll().stream()
                .map(entity -> {
                    log.info("Produto encontrado com sucesso, ID: {}", entity.getId());
                    return productDto(entity);
                }).toList();
    }

    public ProductDto findProductById(Long id) {
        log.info("Buscando produto com id {}", id);
        return productRepository.findById(id)
                .map(entity -> {
                    log.info("Produto com id {} encontrado com sucesso", id);
                    return productDto(entity);
                })
                .orElseThrow(() -> {
                    //log.warn("Falha ao buscar o produto: id {} não encontrado", id);
                    return new ProductNotFoundException(id);
                });
    }

    public ProductDto saveProduct(ProductDto dto) {
        CategoryEntity category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new CategoryNotFoundException(dto.categoryId()));

        ProductEntity newEntity = new ProductEntity();
        newEntity.setName(dto.name());
        newEntity.setPrice(dto.price());
        newEntity.setCategory(category);

        ProductEntity savedEntity = productRepository.save(newEntity);

        return productDto(savedEntity);
    }

    private ProductDto productDto(ProductEntity entity) {
        return new ProductDto(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getCategory() != null ? entity.getCategory().getId() : null);
    }
}