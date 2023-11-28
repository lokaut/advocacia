package br.com.empresaaleatoria.cadastrocia.dto;

import static br.com.empresaaleatoria.cadastrocia.util.DataUtils.formatarDataLocalDateToString;
import static br.com.empresaaleatoria.cadastrocia.util.DataUtils.formatarStringToLocalDate;
import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.empresaaleatoria.cadastrocia.model.Cargo;
import br.com.empresaaleatoria.cadastrocia.model.Cidade;
import br.com.empresaaleatoria.cadastrocia.model.Contato;
import br.com.empresaaleatoria.cadastrocia.model.Endereco;
import br.com.empresaaleatoria.cadastrocia.model.Funcionario;
import br.com.empresaaleatoria.cadastrocia.model.Telefone;
import br.com.empresaaleatoria.cadastrocia.model.type.CargoNomeType;

@Component
public class FuncionarioAssembler {

    public FuncionarioDTO toDTO(Funcionario entity) {
        FuncionarioDTO dto = new FuncionarioDTO();

        dto.setNome(requireNonNull(entity).getNome());
        dto.setCpf(entity.getCpf());

        Endereco endereco = requireNonNull(entity).getEndereco();
        dto.setLogradouro(endereco.getLogradouro());
        dto.setNumero(endereco.getNumero());
        dto.setBairro(endereco.getBairro());

        Cidade cidade = requireNonNull(endereco.getCidade());
        dto.setMunicipio(cidade.getMunicipio());
        dto.setUf(cidade.getUf());
        dto.setCodigoIbge(cidade.getIbge());

        dto.setCep(endereco.getCep());
        dto.setComplemento(endereco.getComplemento());

        Contato contato = requireNonNull(entity).getContato();
        dto.setEmail(contato.getEmail());

        Telefone telefone = requireNonNull(contato.getTelefone());
        dto.setDdd(telefone.getDdd());
        dto.setTelefone(telefone.getNumero());

        Cargo cargo = requireNonNull(entity).getCargo();
        dto.setSalario(cargo.getSalario());
        
        dto.setCargoNome(cargo.getNome().name());

        dto.setDataAdmissao(formatarDataLocalDateToString(entity.getDataAdmissao()));
        dto.setDataNascimento(formatarDataLocalDateToString(entity.getDataNascimento()));
        dto.setDataDesligamento(formatarDataLocalDateToString(entity.getDataDesligamento()));
        dto.setAtivo(entity.getAtivo());

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
        cidade.setIbge(dto.getCodigoIbge());

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
        cargo.setNome(CargoNomeType.valueOf(dto.getCargoNome().toUpperCase()));
        

        funcionario.setCargo(cargo);

        funcionario.setDataAdmissao(formatarStringToLocalDate(dto.getDataAdmissao()) );
        funcionario.setDataNascimento(formatarStringToLocalDate(dto.getDataNascimento()));
        funcionario.setDataDesligamento(formatarStringToLocalDate(dto.getDataDesligamento()));

        return funcionario;
    }
    
    public List<FuncionarioDTO> toDtoList(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
