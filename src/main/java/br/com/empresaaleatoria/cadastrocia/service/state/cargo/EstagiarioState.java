package br.com.empresaaleatoria.cadastrocia.service.state.cargo;

import java.math.BigDecimal;

public class EstagiarioState implements CargoState {

	// estagiario nao tem bonus
	@Override
	public BigDecimal calcularSalario() {
		return BigDecimal.valueOf(2000.00);

	}

}
