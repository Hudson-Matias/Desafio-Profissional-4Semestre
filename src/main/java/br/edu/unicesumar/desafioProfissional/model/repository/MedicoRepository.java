package br.edu.unicesumar.desafioProfissional.model.repository;

import br.edu.unicesumar.desafioProfissional.model.domain.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, String> {

    @Query(exists = true, value = "select * from medico m")
    List<Medico> pesquisaPorNomeNativa(@Param("nome") String nome);
}
