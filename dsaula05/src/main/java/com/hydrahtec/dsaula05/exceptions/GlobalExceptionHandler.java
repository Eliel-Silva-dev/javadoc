package com.hydrahtec.dsaula05.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptonHandler extends ResponseEntityExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<RestErrorMessage> handleCategoryNotFound(CategoryNotFoundException ex, HttpServletRequest request) {
        log.warn("Erro ao buscar a categoria - URI: {}, Mensagem: {}",
                request.getRequestURI(),
                ex.getMessage(),
                ex
        );

        RestErrorMessage error = new RestErrorMessage(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Category Not Found",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<RestErrorMessage> handleProductNotFound(ProductNotFoundException ex, HttpServletRequest request) {
        log.warn("Erro ao buscar o produto - URI: {}, Mensagem: {}",
                request.getRequestURI(),
                ex.getMessage(),
                ex
        );

        RestErrorMessage error = new RestErrorMessage(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Product Not Found",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {

        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage()).toList();

        String path = ((ServletWebRequest) request).getRequest().getRequestURI();

        log.warn("Erro de validação na requisição: {} - Campos inválidos: {}", path, errors);

        RestErrorMessage errorMessage = new RestErrorMessage(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Foram encontrados erros nos campos preenchidos",
                "Validation error",
                path,
                errors
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestErrorMessage> handleGeneralException(Exception ex, HttpServletRequest request) {
        log.error("Erro interno inesperado - URI: {}, Mensagem: {}",
                request.getRequestURI(),
                ex.getMessage(),
                ex
        );

        RestErrorMessage errorMessage = new RestErrorMessage(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Ocorreu um erro inesperado no servidor. Nossa equipe já foi notificada",
                "Internal server error",
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
}
