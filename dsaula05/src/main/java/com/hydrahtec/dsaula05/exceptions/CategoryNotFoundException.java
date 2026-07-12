package com.hydrahtec.dsaula05.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String msg) {
        super(msg);
    }

    public CategoryNotFoundException(Long id) {
        super("Categoria não encontrada, ID: " + id);
    }
}
