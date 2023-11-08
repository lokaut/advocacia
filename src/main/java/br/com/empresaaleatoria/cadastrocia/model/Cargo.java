package br.com.empresaaleatoria.cadastrocia.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cargo {
	
	private String nome;
	
	private BigDecimal salario;
	
	private String descricao;

}
