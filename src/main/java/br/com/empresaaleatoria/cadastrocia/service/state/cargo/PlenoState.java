package br.com.empresaaleatoria.cadastrocia.service.state.cargo;

import java.math.BigDecimal;

public class PlenoState implements CargoState {
	
    @Override
    public BigDecimal calcularSalario() {
		BigDecimal salario = BigDecimal.valueOf(7000.00);
		BigDecimal bonus = BigDecimal.valueOf(500.00);
		return salario.add(bonus);
    }


}
