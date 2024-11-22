package com.ingresso.ingresso.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;
@Getter
@Setter
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Endereco {
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String logradouro;
    @NotNull
    @NotBlank
    @Size(max = 10)
    private String numero;
    @NotNull
    @NotBlank
    @Size(max = 20)
    private String bairro;
    @NotNull
    @NotBlank
    @Size(max = 20)
    private String cidade;
    @NotNull
    @NotBlank
    @Size(max = 2)
    private String estado;
    @NotNull
    @NotBlank
    @Size(max = 2)
    private String pais;
    @NotNull
    @NotBlank
    @Size(max = 8)
    private String cep;
    private String complemento;
}
