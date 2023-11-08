package br.com.empresaaleatoria.cadastrocia.model;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(value ="funcionario")
public class Funcionario {
	
	@Id
	private ObjectId id;

	private String nome;
	
	private String cpf;
	
	@Indexed
	private Contato contato;
	
	@Indexed
	private Endereco endereco;
	
	private LocalDate dataAdmissao;
	
	private LocalDate dataNascimento;
	
	private LocalDate dataDesligamento;
	
	@Indexed
	private Cargo cargo;
	
	
	
}
