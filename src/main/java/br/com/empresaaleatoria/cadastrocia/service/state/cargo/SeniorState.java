package br.com.empresaaleatoria.cadastrocia.service.state.cargo;

import java.math.BigDecimal;

public class SeniorState implements CargoState {
	
    @Override
    public BigDecimal calcularSalario() {
		BigDecimal salario = BigDecimal.valueOf(10000.00);
		BigDecimal bonus = BigDecimal.valueOf(1000.00);
		return salario.add(bonus);
    }


}
