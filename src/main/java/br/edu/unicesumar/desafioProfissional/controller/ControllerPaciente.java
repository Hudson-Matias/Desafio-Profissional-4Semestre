package br.edu.unicesumar.desafioProfissional.controller;

import br.edu.unicesumar.desafioProfissional.model.domain.Paciente;
import br.edu.unicesumar.desafioProfissional.model.repository.RepositoryPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/paciente")
public class ControllerPaciente {

    @Autowired
    private RepositoryPaciente repositoryPaciente;

    @GetMapping
    public ResponseEntity<List<Paciente>>  findAll(){
        return ResponseEntity.ok(repositoryPaciente.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getId(@PathVariable Long id){
        Optional<Paciente> paciente = repositoryPaciente.findById(id);
        if (paciente.isPresent()){
            return ResponseEntity.ok(paciente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/nativa")
    public ResponseEntity<List<Paciente>> getNativo(@RequestParam("nome") String nome){
        return ResponseEntity.ok(repositoryPaciente.pesquisaPorNomeNativa(nome));
    }

    @PostMapping
    public ResponseEntity<Paciente> create(@RequestBody Paciente novoPaciente){
        return ResponseEntity.ok(repositoryPaciente.save(novoPaciente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@PathVariable Long id, @RequestBody Paciente editPaciente){
        Paciente paciente = repositoryPaciente.findById(id).orElse(new Paciente());

        paciente.setId(editPaciente.getId());
        paciente.setCpf(editPaciente.getCpf());
        paciente.setNome(editPaciente.getNome());
        paciente.setEmail(editPaciente.getEmail());

        return ResponseEntity.ok(repositoryPaciente.save(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        repositoryPaciente.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
