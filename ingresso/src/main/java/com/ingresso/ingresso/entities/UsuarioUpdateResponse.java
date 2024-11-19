package com.ingresso.ingresso.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioUpdateResponse {
    private String id;
    private String cpf;
    private String email;
    private String nomeCompleto;
    private String senha;
    private String apelido;
    private String dataNascimento;
    private Long celular;
    private String genero;
    private String dataAtualizacao;
    private String dataCadastro;
    private Endereco endereco;
    private String codigoDeSeguranca;
}


