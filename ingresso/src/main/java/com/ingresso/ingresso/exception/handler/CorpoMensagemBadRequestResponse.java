package com.ingresso.ingresso.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class CorpoMensagemBadRequestResponse {
    private Integer status;
    private String timestamp;
    private String type;
    private String title;
    private String detail;
    private List<Erro> erros;


}
