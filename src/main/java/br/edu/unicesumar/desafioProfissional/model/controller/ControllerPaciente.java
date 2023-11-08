package br.edu.unicesumar.desafioProfissional.model.controller;

import br.edu.unicesumar.desafioProfissional.model.domain.Paciente;
import br.edu.unicesumar.desafioProfissional.model.services.ServicesPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/paciente")
public class ControllerPaciente {

    @Autowired
    private ServicesPaciente servicos;

    @GetMapping
    public ResponseEntity<List<Paciente>>  findAll(){
        List<Paciente> list = servicos.findAll();
        return ResponseEntity.ok().body(list);
    }
}
