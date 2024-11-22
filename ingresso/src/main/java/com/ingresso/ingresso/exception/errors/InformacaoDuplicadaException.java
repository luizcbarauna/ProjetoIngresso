package com.ingresso.ingresso.exception.errors;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class InformacaoDuplicadaException extends ErrorsException {
    public InformacaoDuplicadaException(String message) {
        super(HttpStatus.CONFLICT.value(), "/em-conflito", "Requisição em Conflito", message);
    }
}
