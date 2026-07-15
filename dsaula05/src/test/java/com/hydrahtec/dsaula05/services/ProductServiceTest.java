package com.hydrahtec.dsaula05.services;

import com.hydrahtec.dsaula05.entities.CategoryEntity;
import com.hydrahtec.dsaula05.entities.ProductEntity;
import com.hydrahtec.dsaula05.models.ProductDto;
import com.hydrahtec.dsaula05.repositories.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    @DisplayName("Deve retornar produto quando houver dados")
    void deveReturn_ProductDtoList_When_ExistData() {
        //ARANGE
        CategoryEntity category = new CategoryEntity(2L, "Eletronics");
        ProductEntity entity = new ProductEntity(1L, "NoteBook", 150.00, category);
        when(productRepository.findAll()).thenReturn(List.of(entity));

        //ACT
        List<ProductDto> result = productService.findAllProduct();

        //ASSERTIONS
        assertThat(result).hasSize(1);
        assertThat(result.getFirst().name()).isEqualTo("NoteBook");

    }

    @Test
    @DisplayName("Deve retornar produto quando o id existir")
    void deveReturn_ProductDto_When_ExistId() {
        //ARANGE
        Long id = 1L;
        CategoryEntity category = new CategoryEntity(2L, "Eletronics");
        ProductEntity entity = new ProductEntity(id, "Tablete", 100.00, category);
        when(productRepository.findById(id)).thenReturn(Optional.of(entity));

        //ACT
        ProductDto result = productService.findProductById(id);

        //ASSERTIONS
        assertThat(result).isNotNull();
        assertThat(result.name()).isEqualTo("Tablete");

    }
}