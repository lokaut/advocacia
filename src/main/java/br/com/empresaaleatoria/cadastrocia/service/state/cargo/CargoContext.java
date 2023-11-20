package br.com.empresaaleatoria.cadastrocia.service.state.cargo;

import java.math.BigDecimal;

public class CargoContext {

	private CargoState cargoState;

	public CargoContext(CargoState cargoState) {
		this.cargoState = cargoState;
	}

	public BigDecimal calcularSalario() {
		return cargoState.calcularSalario();
	}

	public void setCargoState(CargoState cargoState) {
		this.cargoState = cargoState;
	}
}
