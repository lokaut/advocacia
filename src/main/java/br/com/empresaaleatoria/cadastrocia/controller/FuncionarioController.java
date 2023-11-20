package br.com.empresaaleatoria.cadastrocia.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresaaleatoria.cadastrocia.dto.FuncionarioAssembler;
import br.com.empresaaleatoria.cadastrocia.dto.FuncionarioDTO;
import br.com.empresaaleatoria.cadastrocia.model.Funcionario;
import br.com.empresaaleatoria.cadastrocia.service.FuncionarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
@Validated
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private FuncionarioAssembler assembler;

	@PostMapping()
	public ResponseEntity<FuncionarioDTO> criarFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO) {
		Funcionario funcionario = assembler.toEntity(funcionarioDTO);
		Funcionario novoFuncionario = funcionarioService.criarFuncionario(funcionario);
		return new ResponseEntity<>(assembler.toDTO(novoFuncionario), CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<FuncionarioDTO>> buscarTodosFuncionarios() {
		List<Funcionario> funcionarios = funcionarioService.findAllFuncionarios();
		assembler.toDtoList(funcionarios);
		return new ResponseEntity<>(assembler.toDtoList(funcionarios), OK);
	}
	
	@GetMapping("cpf/{cpf}")
	public ResponseEntity<FuncionarioDTO> buscarCpf(@PathVariable("cpf") String cpf) {
		Funcionario funcionarioEncontrado = funcionarioService.findByCPF(cpf);
		return new ResponseEntity<>(assembler.toDTO(funcionarioEncontrado), OK);
	}
	
	@DeleteMapping("desligamento/{cpf}")
	public ResponseEntity<FuncionarioDTO> demitirFuncionario(@PathVariable("cpf") String cpf) {
		Funcionario funcionarioEncontrado = funcionarioService.findByCPF(cpf);
		funcionarioService.desligarFuncionario(funcionarioEncontrado);
		return new ResponseEntity<>(NO_CONTENT);
	}
	
    @GetMapping("/status")
    public String checkStatus() {
        return "A aplicação de cadastrocia está funcionando!";
    }
}
