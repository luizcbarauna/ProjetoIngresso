package com.ingresso.ingresso.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UsuarioListResponse {
    private String id;
    private String cpf;
    private String email;
    private String nomeCompleto;
}
