package br.edu.unicesumar.desafioProfissional.model.services;

import br.edu.unicesumar.desafioProfissional.model.domain.Paciente;
import br.edu.unicesumar.desafioProfissional.model.repository.RepositoryPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesPaciente {

    @Autowired
    private RepositoryPaciente repo;

    public List<Paciente> findAll(){
        return repo.findAll();
    }
}
