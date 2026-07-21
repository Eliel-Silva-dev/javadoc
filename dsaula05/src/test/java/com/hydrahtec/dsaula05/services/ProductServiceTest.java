package com.hydrahtec.dsaula05.services;

import com.hydrahtec.dsaula05.entities.CategoryEntity;
import com.hydrahtec.dsaula05.entities.ProductEntity;
import com.hydrahtec.dsaula05.exceptions.CategoryNotFoundException;
import com.hydrahtec.dsaula05.exceptions.ProductNotFoundException;
import com.hydrahtec.dsaula05.models.ProductDto;
import com.hydrahtec.dsaula05.repositories.CategoryRepository;
import com.hydrahtec.dsaula05.repositories.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

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

    @Test
    @DisplayName("Deve retornar produto quando o id existir")
    void deve_ThrowException_When_NotExistId() {
        //ARANGE
        Long id = 99L;
        when(productRepository.findById(id)).thenReturn(Optional.empty());

        //ACT and ASSERTIONS
        assertThatThrownBy(() -> productService.findProductById(id))
                .isInstanceOf(ProductNotFoundException.class)
                .hasMessage("Produto não encontrado, ID: 99");
    }

    @Test
    @DisplayName("Deve salvar entity no banco de dados")
    void deve_salvar_entity_noBancoDeDados() {
        //ARANGE
        CategoryEntity category = new CategoryEntity(2L, "Eletronics");
        ProductDto dto = new ProductDto(null, "PC gamer", 550.00, 2L);

        //retorna a entidade quando o save for chamado
        when(categoryRepository.findById(2L)).thenReturn(Optional.of(category));
        when(productRepository.save(any(ProductEntity.class))).thenAnswer(i -> i.getArguments()[0]);

        //ACT
        ProductDto result = productService.saveProduct(dto);

        //ASSERTIONS
        ArgumentCaptor<ProductEntity> captor = ArgumentCaptor.forClass(ProductEntity.class);
        verify(productRepository, times(1)).save(captor.capture());

        ProductEntity savedEntity = captor.getValue();
        assertThat(savedEntity.getName()).isEqualTo("PC gamer");
        assertThat(savedEntity.getPrice()).isEqualTo(550.0);
        assertThat(savedEntity.getCategory().getId()).isEqualTo(2L);
    }

    @Test
    @DisplayName("Deve lançar exception quando id não existir ao salvar")
    void sould_throwException_when_notExistId_toSave() {
        //ARRANGE
        ProductDto dto = new ProductDto(null, "PC gamer", 550.00, 99L);
        when(categoryRepository.findById(99L)).thenReturn(Optional.empty());

        //ACT ASSERTIONS
        assertThatThrownBy(() -> productService.saveProduct(dto))
                .isInstanceOf(CategoryNotFoundException.class)
                .hasMessage("Categoria não encontrada, ID: 99");

        verify(productRepository, never()).save(any());
    }
}