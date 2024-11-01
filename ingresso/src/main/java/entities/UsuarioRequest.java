package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

public class UsuarioRequest {

    private Long id;
    private String cpf;
    private String email;
    private String nomeCompleto;
    private String senha;
    private String apelido;
    private Date dataNascimento;
    private Integer celular;
    private char genero;
    private Date dataAtualizacao;
    private Date dataCadastro;
    private Endereco endereco;
}
