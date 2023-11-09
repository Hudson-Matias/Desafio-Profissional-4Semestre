package br.edu.unicesumar.desafioProfissional.model.repository;

import br.edu.unicesumar.desafioProfissional.model.domain.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, Integer> {
}
