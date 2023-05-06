package com.avaliacao.powerkr.infra.exception;

public class ApiException extends RuntimeException {

    public ApiException(String mensagem) {
        super(mensagem);
    }
}
