package br.com.empresaaleatoria.cadastrocia.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cidade {
	
	private String municipio;
	
	private String uf;
	
	private String ibge;

}
