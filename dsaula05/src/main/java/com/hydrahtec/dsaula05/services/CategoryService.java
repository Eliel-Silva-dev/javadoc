package com.hydrahtec.dsaula05.services;

import com.hydrahtec.dsaula05.entities.CategoryEntity;
import com.hydrahtec.dsaula05.exceptions.CategoryNotFoundException;
import com.hydrahtec.dsaula05.models.CategoryDto;
import com.hydrahtec.dsaula05.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private static final Logger log = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDto> findAllCategories() {
        log.info("Buscando todas as categorias");
        return categoryRepository.findAll().stream()
                .map(entity -> {
                    log.info("Categia encontrada com sucesso");
                    return categoryDto(entity);
                }).toList();
    }

    public CategoryDto findCategoryById(Long id) {
        log.info("Buscando categoria com id {}", id);
        return categoryRepository.findById(id)
                .map(entity -> {
                    log.info("Categoria com id {} encontrada com sucesso", id);
                    return categoryDto(entity);
                }).orElseThrow(() -> {
                    //log.error("Falha ao buscar categoria: id {} não encontrada", id);
                    return new CategoryNotFoundException(id);
                });
    }

    public CategoryDto saveCategory(CategoryDto categoryDto) {
        CategoryEntity newEntity = new CategoryEntity();
        newEntity.setName(categoryDto.name());

        return categoryDto(categoryRepository.save(newEntity));
    }
    private CategoryDto categoryDto(CategoryEntity entity) {
        return new CategoryDto(
                entity.getId(),
                entity.getName());
    }
}