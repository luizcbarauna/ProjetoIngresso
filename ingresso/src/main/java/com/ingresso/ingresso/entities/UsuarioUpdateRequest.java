package com.ingresso.ingresso.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ingresso.ingresso.annotations.AniversarioValido;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
@Getter
@Setter
public class UsuarioUpdateRequest {


    private String cpf;
    private String email;
    private String nomeCompleto;
    private String senha;
    private String apelido;
    private String dataNascimento;
    private Long celular;
    private String genero;
    private Endereco endereco;
}
