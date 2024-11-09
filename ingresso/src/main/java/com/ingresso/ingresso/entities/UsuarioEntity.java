package com.ingresso.ingresso.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.ingresso.ingresso.annotations.AniversarioValido;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;


import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    private String id;
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
    private Integer genero;
    @JsonProperty(value = "data_atualizacao" )
    private LocalDateTime dataAtualizacao;
    @JsonProperty("data_cadastro")
    private LocalDateTime dataCadastro;
    @Embedded
    private Endereco endereco;

}
