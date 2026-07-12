package com.hydrahtec.dsaula05.exceptions;

import java.time.LocalDateTime;

public record RestErrorMessage(
        LocalDateTime timestamp,
        int status,
        String message,
        String error,
        String path) {
}
