package com.ingresso.ingresso.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioResponse {
    private String id;
    private String cpf;
    private String email;
    private String nomeCompleto;
    private String apelido;
    private String dataNascimento;
    private Long celular;
    private String genero;
    private String dataCadastro;
    private Endereco endereco;
}
