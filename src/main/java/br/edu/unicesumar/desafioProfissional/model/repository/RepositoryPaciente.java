package br.edu.unicesumar.desafioProfissional.model.repository;

import br.edu.unicesumar.desafioProfissional.model.domain.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPaciente extends MongoRepository<Paciente, String> {

    @Query(exists = true, value = "select * from paciente p ")
    List<Paciente> pesquisaPorNomeNativa(@Param("nome") String nome);

}
