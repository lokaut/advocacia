package br.com.empresaaleatoria.cadastrocia.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Endereco {
	
	private String logradouro;
	
	private String numero;
	
	private String bairro;
	
	private Cidade cidade;
	
	private String cep;
	
	private String complemento;

}
