package br.com.empresaaleatoria.cadastrocia.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuncionarioDTO {
	
	@NotBlank(message = "O campo 'nome' não pode estar em branco.")
    private String nome;

    private String cpf;

    private String logradouro;

    private String numero;

    private String bairro;

    private String municipio;

    private String uf;

    private String codigoIbge;

    private String cep;

    private String complemento;

    private String email;

    private String ddd;

    private String telefone;

    private BigDecimal salario;

    private String descricao;

    private LocalDate dataAdmissao;

    private LocalDate dataNascimento;

    private LocalDate dataDesligamento;

}
