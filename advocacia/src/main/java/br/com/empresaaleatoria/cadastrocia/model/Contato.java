package br.com.empresaaleatoria.cadastrocia.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Contato {
	
	private String email;
	
	private Telefone telefone;

}
