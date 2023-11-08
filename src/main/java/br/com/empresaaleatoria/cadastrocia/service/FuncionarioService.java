package br.com.empresaaleatoria.cadastrocia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresaaleatoria.cadastrocia.Repository.FuncionarioRepository;
import br.com.empresaaleatoria.cadastrocia.model.Funcionario;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario criarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }
}

