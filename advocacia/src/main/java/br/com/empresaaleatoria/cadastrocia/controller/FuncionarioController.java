package br.com.empresaaleatoria.cadastrocia.controller;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping("/criar")
	public ResponseEntity<FuncionarioDTO> criarFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO) {
		Funcionario funcionario = assembler.toEntity(funcionarioDTO);
		Funcionario novoFuncionario = funcionarioService.criarFuncionario(funcionario);
		return new ResponseEntity<>(assembler.toDTO(novoFuncionario), CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<Void> criarFuncionarios() {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
    @GetMapping("/status")
    public String checkStatus() {
        return "A aplicação de advocacia está funcionando!";
    }
}
