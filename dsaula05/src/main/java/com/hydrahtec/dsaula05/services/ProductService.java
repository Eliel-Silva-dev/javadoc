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
        log.info("Find all products");
        return productRepository.findAll().stream()
                .map(entity -> {
                    log.info("Produto encontrado com sucesso");
                    return new ProductDto(
                            entity.getName(),
                            entity.getPrice(),
                            entity.getCategory() != null ? entity.getCategory().getId() : null
                    );
                }).toList();
    }

    public ProductDto findProductById(Long id) {
        log.info("Buscando produto com id {}", id);
        return productRepository.findById(id)
                .map(entity -> {
                    log.info("Produto com id {} encontrado com sucesso", id);
                    return new ProductDto(
                            entity.getName(),
                            entity.getPrice(),
                            entity.getCategory() != null ? entity.getCategory().getId() : null);
                })
                .orElseThrow(() -> {
                    log.info("Falha ao buscar o produto: id {} não encontrado", id);
                    return new ProductNotFoundException("product not found");
                });
    }
}
