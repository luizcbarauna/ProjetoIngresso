package com.ingresso.ingresso.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter

@AllArgsConstructor
public enum GeneroEnum {
    MASCULINO("M", 1),
    FEMININO("F", 2),
    NAO_BINARIO("B", 3),
    PREFIRO_NAO_INFORMAR("N", 4);
    private String codigo;
    private int codigoBanco;
}
