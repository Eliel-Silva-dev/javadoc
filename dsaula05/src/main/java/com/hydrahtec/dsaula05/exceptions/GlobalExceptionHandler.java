package com.hydrahtec.dsaula05.exceptions;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CategoryNotFoundException.class, ProductNotFoundException.class})
    public ResponseEntity<RestErrorMessage> notFoundHandler(Exception ex, HttpRequest request) {

        RestErrorMessage error = new RestErrorMessage(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                request.getURI().getPath()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
