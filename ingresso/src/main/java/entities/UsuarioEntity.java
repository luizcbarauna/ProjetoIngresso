package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;


import java.util.Date;
@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CPF
    private String cpf;
    @Email
    private String email;
    @JsonProperty(value = "nome_completo")
    private String nomeCompleto;
    private String senha;
    private String apelido;
    @JsonProperty(value = "data_nascimento")
    private Date dataNascimento;
    private Integer celular;
    private char genero;
    @JsonProperty(value = "data_atualizacao" )
    private Date dataAtualizacao;
    @JsonProperty("data_cadastro")
    private Date dataCadastro;
    private Endereco endereco;

}
