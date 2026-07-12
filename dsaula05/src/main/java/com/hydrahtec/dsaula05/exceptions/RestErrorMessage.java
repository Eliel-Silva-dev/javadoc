package com.hydrahtec.dsaula05.exceptions;

import java.time.LocalDateTime;

public record RestErrorMessage(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path) {
}
