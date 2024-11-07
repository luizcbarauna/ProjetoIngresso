package com.ingresso.ingresso.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class UsuarioRequest {
    @NotNull
    @NotBlank
    @CPF
    private String cpf;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotBlank
    @JsonProperty(value = "nome_completo")
    private String nomeCompleto;
    private String senha;
    private String apelido;
    @JsonProperty(value = "data_nascimento")
    private String dataNascimento;
    private Long celular;
    private String genero;
    @Embedded
    private Endereco endereco;
}
