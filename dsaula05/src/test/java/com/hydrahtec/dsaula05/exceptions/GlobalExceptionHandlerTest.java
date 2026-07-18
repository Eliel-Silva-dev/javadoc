package com.hydrahtec.dsaula05.exceptions;

import com.hydrahtec.dsaula05.controllers.ProductController;
import com.hydrahtec.dsaula05.services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Test
    @DisplayName("Deve retornar status 404 e corpo de erro quando ProductNotFoundException for lançada")
    void deve_retornarError_when_notFoundProduct() throws Exception {

        //ARRANGE
        Long idNotExist = 99L;
        when(productService.findProductById(idNotExist))
                .thenThrow(new ProductNotFoundException(idNotExist));

        //ACT and ASSERTIONS
        mockMvc.perform(get("/products/{id}", idNotExist)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Produto não encontrado, ID: 99"))
                .andExpect(jsonPath("$.error").value("Product Not Found"));
    }
}