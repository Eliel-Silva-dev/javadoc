package com.hydrahtec.dsaula05.exceptions;

public class productNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public productNotFoundException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "productNotFoundException{}";
    }
}
