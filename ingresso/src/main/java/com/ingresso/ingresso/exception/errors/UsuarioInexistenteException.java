package com.ingresso.ingresso.exception.errors;

import org.springframework.http.HttpStatus;

public class UsuarioInexistenteException extends ErrorsException {

    public UsuarioInexistenteException(String message) {
        super(HttpStatus.NOT_FOUND.value(), "/nao-encontrado", "Nenhum recurso encontrado", message);
    }
}
