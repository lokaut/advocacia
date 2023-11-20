package br.com.empresaaleatoria.cadastrocia.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CepResponse {

	private String cep;

	private String logradouro;

	private String bairro;

	private String localidade; // Cidade

	private String uf;

	private String ibge;

}
