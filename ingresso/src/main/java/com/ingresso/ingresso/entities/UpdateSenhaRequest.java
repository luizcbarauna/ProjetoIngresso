package com.ingresso.ingresso.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateSenhaRequest {
    @JsonProperty(value = "codigo_seguranca")
    private String codigoDeSeguranca;
    @JsonProperty(value = "nova_senha")
    private String novaSenha;
    @JsonProperty(value = "senha_atual")
    private String senhaAtual;
}
