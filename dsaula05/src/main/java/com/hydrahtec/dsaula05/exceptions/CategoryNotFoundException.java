package com.hydrahtec.dsaula05.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CategoryNotFoundException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "Categoria não encontrada no banco";
    }
}
