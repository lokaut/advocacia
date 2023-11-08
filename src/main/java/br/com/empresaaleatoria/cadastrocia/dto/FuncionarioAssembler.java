package br.com.empresaaleatoria.cadastrocia.dto;

import static java.util.Objects.requireNonNull;

import org.springframework.stereotype.Component;

import br.com.empresaaleatoria.cadastrocia.model.Cargo;
import br.com.empresaaleatoria.cadastrocia.model.Cidade;
import br.com.empresaaleatoria.cadastrocia.model.Contato;
import br.com.empresaaleatoria.cadastrocia.model.Endereco;
import br.com.empresaaleatoria.cadastrocia.model.Funcionario;
import br.com.empresaaleatoria.cadastrocia.model.Telefone;

@Component
public class FuncionarioAssembler {

    public FuncionarioDTO toDTO(Funcionario funcionario) {
        FuncionarioDTO dto = new FuncionarioDTO();

        dto.setNome(requireNonNull(funcionario).getNome());
        dto.setCpf(funcionario.getCpf());

        Endereco endereco = requireNonNull(funcionario).getEndereco();
        dto.setLogradouro(endereco.getLogradouro());
        dto.setNumero(endereco.getNumero());
        dto.setBairro(endereco.getBairro());

        Cidade cidade = requireNonNull(endereco.getCidade());
        dto.setMunicipio(cidade.getMunicipio());
        dto.setUf(cidade.getUf());
        dto.setCodigoIbge(cidade.getCodigoIbge());

        dto.setCep(endereco.getCep());
        dto.setComplemento(endereco.getComplemento());

        Contato contato = requireNonNull(funcionario).getContato();
        dto.setEmail(contato.getEmail());

        Telefone telefone = requireNonNull(contato.getTelefone());
        dto.setDdd(telefone.getDdd());
        dto.setTelefone(telefone.getNumero());

        Cargo cargo = requireNonNull(funcionario).getCargo();
        dto.setSalario(cargo.getSalario());
        dto.setDescricao(cargo.getDescricao());

        dto.setDataAdmissao(funcionario.getDataAdmissao());
        dto.setDataNascimento(funcionario.getDataNascimento());
        dto.setDataDesligamento(funcionario.getDataDesligamento());

        return dto;
    }

    public Funcionario toEntity(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(requireNonNull(dto).getNome());
        funcionario.setCpf(dto.getCpf());

        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setNumero(dto.getNumero());
        endereco.setBairro(dto.getBairro());

        Cidade cidade = new Cidade();
        cidade.setMunicipio(dto.getMunicipio());
        cidade.setUf(dto.getUf());
        cidade.setCodigoIbge(dto.getCodigoIbge());

        endereco.setCidade(cidade);
        endereco.setCep(dto.getCep());
        endereco.setComplemento(dto.getComplemento());

        funcionario.setEndereco(endereco);

        Contato contato = new Contato();
        contato.setEmail(dto.getEmail());

        Telefone telefone = new Telefone();
        telefone.setDdd(dto.getDdd());
        telefone.setNumero(dto.getTelefone());

        contato.setTelefone(telefone);

        funcionario.setContato(contato);

        Cargo cargo = new Cargo();
        cargo.setSalario(dto.getSalario());
        cargo.setDescricao(dto.getDescricao());

        funcionario.setCargo(cargo);

        funcionario.setDataAdmissao(dto.getDataAdmissao());
        funcionario.setDataNascimento(dto.getDataNascimento());
        funcionario.setDataDesligamento(dto.getDataDesligamento());

        return funcionario;
    }
}
