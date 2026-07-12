package com.hydrahtec.dsaula05.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record RestErrorMessage(
        LocalDateTime timestamp,
        HttpStatus status,
        String error,
        String path) {
}
