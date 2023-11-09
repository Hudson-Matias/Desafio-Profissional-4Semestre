package br.edu.unicesumar.desafioProfissional.model.services;

import br.edu.unicesumar.desafioProfissional.model.domain.Medico;
import br.edu.unicesumar.desafioProfissional.model.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MedicoServices {

    @Autowired
    private MedicoRepository repository;

    public List<Medico> findAll(){
        return repository.findAll();
    }

}
