package com.avaliacao.powerkr.infra.exception;

import com.avaliacao.powerkr.domain.exception.ApiException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity tratarErroApi(ApiException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
