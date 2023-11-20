package br.com.empresaaleatoria.cadastrocia.service;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresaaleatoria.cadastrocia.Repository.FuncionarioRepository;
import br.com.empresaaleatoria.cadastrocia.model.Funcionario;
import br.com.empresaaleatoria.cadastrocia.model.type.CargoNomeType;
import br.com.empresaaleatoria.cadastrocia.service.state.cargo.CargoContext;
import br.com.empresaaleatoria.cadastrocia.service.state.cargo.CargoState;
import br.com.empresaaleatoria.cadastrocia.service.state.cargo.EstagiarioState;
import br.com.empresaaleatoria.cadastrocia.service.state.cargo.JuniorState;
import br.com.empresaaleatoria.cadastrocia.service.state.cargo.PlenoState;
import br.com.empresaaleatoria.cadastrocia.service.state.cargo.SeniorState;
import br.com.empresaaleatoria.cadastrocia.util.CepService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	public Funcionario criarFuncionario(Funcionario funcionario) {
		Funcionario funcionarioCadastrado = repository.findByCpf(funcionario.getCpf());
		if (nonNull(funcionarioCadastrado)) {
			throw new EntityNotFoundException("Funcionário já cadastrado");
		}
	    CargoState cargoState = obterCargoStateComBaseNaDescricao(funcionario.getCargo().getNome());
	    CargoContext cargoContext = new CargoContext(cargoState);
	    funcionario.getCargo().setSalario(cargoContext.calcularSalario());
	    funcionario.setAtivo(TRUE);
	    CepService.preencherEnderecoComCep(funcionario.getEndereco(), funcionario.getEndereco().getCep());
		return repository.save(funcionario);
	}

	public List<Funcionario> findAllFuncionarios() {
		return repository.findAll();

	}

	public Funcionario findByCPF(String cpf) {
		Funcionario funcionario = repository.findByCpf(cpf);
		if (isNull(funcionario)) {
			throw new EntityNotFoundException("Funcionário não encontrado");
		}
		return funcionario;

	}
	

	public void desligarFuncionario(Funcionario funcionario) {
		funcionario.setAtivo(FALSE);
		funcionario.setDataDesligamento(LocalDate.now());
		repository.save(funcionario);
	}
	
	
	private CargoState obterCargoStateComBaseNaDescricao(CargoNomeType descricaoType) {
		switch (descricaoType) {
		case ESTAGIARIO:
			return new EstagiarioState();
		case JUNIOR:
			return new JuniorState();
		case PLENO:
			return new PlenoState();
		case SENIOR:
			return new SeniorState();
		default:
			throw new IllegalArgumentException("Descrição de cargo desconhecida: " + descricaoType.name());
		}
	}
}
