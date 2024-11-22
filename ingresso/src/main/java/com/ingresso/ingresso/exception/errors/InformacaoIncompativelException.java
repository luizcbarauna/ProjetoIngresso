package com.ingresso.ingresso.exception.errors;

import org.springframework.http.HttpStatus;

public class InformacaoIncompativelException extends ErrorsException {
    public InformacaoIncompativelException(String message) {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), "/nao-processada", "A Requisicao nao pode ser processada", message);
    }
}
