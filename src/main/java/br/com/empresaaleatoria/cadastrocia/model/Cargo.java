package br.com.empresaaleatoria.cadastrocia.model;

import java.math.BigDecimal;

import br.com.empresaaleatoria.cadastrocia.model.type.CargoNomeType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cargo {
	
	private BigDecimal salario;
	
	private CargoNomeType nome;

}
