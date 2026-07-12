package com.hydrahtec.dsaula05.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(Long id) {
        super("Produto não encontrado, ID: " + id);
    }
}
