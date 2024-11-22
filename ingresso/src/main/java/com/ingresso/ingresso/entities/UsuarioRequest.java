package com.ingresso.ingresso.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ingresso.ingresso.annotations.AniversarioValido;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
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
    @Size(max = 100, min = 2)
    private String nomeCompleto;
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String senha;
    @Size(max = 20)
    private String apelido;
    @NotNull
    @NotBlank
    @AniversarioValido
    @JsonProperty(value = "data_nascimento")
    private String dataNascimento;
    @NotNull
    @NotBlank
    @Size(min = 11, max = 11)
    private Long celular;
    @NotNull
    @NotBlank
    @Size(max = 2)
    private String genero;

    private String codigoDeSeguranca;
    @Embedded
    private Endereco endereco;
}
