package br.edu.unicesumar.desafioProfissional.controller;

import br.edu.unicesumar.desafioProfissional.model.domain.Medico;
import br.edu.unicesumar.desafioProfissional.model.services.MedicoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/medico")
public class MedicoController {

    @Autowired
    private MedicoServices services;

    @GetMapping
    public ResponseEntity<List<Medico>> findAll(){
        List<Medico> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

}
