package com.hydrahtec.dsaula05.exceptions;

public class ProductNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "productNotFoundException{}";
    }
}
