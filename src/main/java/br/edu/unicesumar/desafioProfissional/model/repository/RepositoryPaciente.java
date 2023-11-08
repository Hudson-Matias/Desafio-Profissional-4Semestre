package br.edu.unicesumar.desafioProfissional.model.repository;

import br.edu.unicesumar.desafioProfissional.model.domain.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPaciente extends MongoRepository<Paciente, String> {

}
