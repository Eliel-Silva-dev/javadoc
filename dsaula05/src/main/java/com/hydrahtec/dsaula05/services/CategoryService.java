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
import java.util.Optional;

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
                    return new CategoryDto(
                            entity.getId(),
                            entity.getName()
                    );
                }).toList();
    }

    public CategoryDto findCategoryById(Long id) {
        Optional<CategoryEntity> category = categoryRepository.findById(id);

        if (category.isPresent()) {
            return category.get();
        } else {
            throw new CategoryNotFoundException("Category not found");
        }
    }
}
