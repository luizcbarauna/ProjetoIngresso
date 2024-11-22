package com.ingresso.ingresso.exception.badRequest;

import com.ingresso.ingresso.exception.handler.Erro;

import java.util.ArrayList;
import java.util.List;

public class CamposAusentesException extends BadRequestException {
    public CamposAusentesException(String message, String field, String detalheErro) {
        super("/campoausente", "Há campos ausentes no corpo da requisição.", message, criarListaErros(field, detalheErro));
    }

    private static List<Erro> criarListaErros(String field, String detalheErro) {
        List<Erro> erros = new ArrayList<>();
        erros.add(new Erro(field, detalheErro));
        return erros;
    }
}
