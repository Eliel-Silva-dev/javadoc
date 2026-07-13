package com.hydrahtec.dsaula05.exceptions;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public record RestErrorMessage(
        LocalDateTime timestamp,
        int status,
        String message,
        String error,
        String path,
        List<String> errors) {
    public RestErrorMessage(LocalDateTime timestamp,
                            int status,
                            String message,
                            String error,
                            String path) {
        this(timestamp, status, message, error, path, Collections.emptyList());

    }
}
