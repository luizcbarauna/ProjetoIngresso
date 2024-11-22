package com.ingresso.ingresso.exception.badRequest;

import com.ingresso.ingresso.exception.handler.Erro;

import java.util.ArrayList;
import java.util.List;

public class FormatoCodigoInvalidoException extends BadRequestException {
    public FormatoCodigoInvalidoException(String message, String field, String detalheErro) {
        super("/formato-invalido", "Formato do Código Inválido", message, criarListaErros(field, detalheErro));
    }

    private static List<Erro> criarListaErros(String field, String detalheErro) {
        List<Erro> erros = new ArrayList<>();
        erros.add(new Erro(field, detalheErro));
        return erros;
    }

}
