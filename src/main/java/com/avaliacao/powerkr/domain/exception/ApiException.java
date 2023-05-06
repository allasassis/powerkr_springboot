package com.avaliacao.powerkr.domain.exception;

public class ApiException extends RuntimeException {

    public ApiException(String mensagem) {
        super(mensagem);
    }
}
