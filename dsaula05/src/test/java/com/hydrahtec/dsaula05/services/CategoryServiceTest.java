package com.hydrahtec.dsaula05.services;

import com.hydrahtec.dsaula05.entities.CategoryEntity;
import com.hydrahtec.dsaula05.exceptions.CategoryNotFoundException;
import com.hydrahtec.dsaula05.models.CategoryDto;
import com.hydrahtec.dsaula05.repositories.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
    @Mock
    CategoryRepository categoryRepository;

    @InjectMocks
    CategoryService categoryService;

    @Test
    @DisplayName("Deve retornar lista de categorias se existir dados")
    public void should_return_categoryList_when_ExistData() {
        //ARRANGE
        CategoryEntity category = new CategoryEntity(1L, "Eletronics");
        when(categoryRepository.findAll()).thenReturn(List.of(category));

        //ACT
        List<CategoryDto> result = categoryService.findAllCategories();

        //ASSERTIONS
        assertThat(result).hasSize(1);
        assertThat(result.getFirst().name()).isEqualTo("Eletronics");
    }

    @Test
    @DisplayName("Deve retornar categorias se id existir")
    public void should_return_category_when_ExistId() {
        //ARRANGE
        Long id = 1L;
        CategoryEntity category = new CategoryEntity(id, "Books");
        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));

        //ACT
        CategoryDto result = categoryService.findCategoryById(id);

        //ASSERTIONS
        assertThat(result).isNotNull();
        assertThat(result.name()).isEqualTo("Books");
    }

    @Test
    @DisplayName("Deve lançar exception se id não existir")
    public void should_throwException_when_NotExistId() {
        //ARRANGE
        Long id = 99L;
        when(categoryRepository.findById(id)).thenReturn(Optional.empty());

        //ACT and ASSERTIONS
        assertThatThrownBy(() -> categoryService.findCategoryById(id))
                .isInstanceOf(CategoryNotFoundException.class)
                .hasMessage("Categoria não encontrada, ID: 99");
    }
}