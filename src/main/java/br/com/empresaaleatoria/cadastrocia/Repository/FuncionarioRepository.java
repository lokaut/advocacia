package br.com.empresaaleatoria.cadastrocia.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.empresaaleatoria.cadastrocia.model.Funcionario;

public interface FuncionarioRepository extends MongoRepository<Funcionario, ObjectId> {
	
}
