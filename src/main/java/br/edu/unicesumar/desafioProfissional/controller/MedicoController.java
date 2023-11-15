package br.edu.unicesumar.desafioProfissional.controller;

import br.edu.unicesumar.desafioProfissional.model.domain.Medico;
import br.edu.unicesumar.desafioProfissional.model.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public ResponseEntity<List<Medico>> findAll(){
        return ResponseEntity.ok(medicoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> getId(@PathVariable String id){
        Optional<Medico> medico = medicoRepository.findById(id);
        if (medico.isPresent()){
            return ResponseEntity.ok(medico.get());
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/nativa")
    public ResponseEntity<List<Medico>> getNativo(@RequestParam("nome") String nome){
        return ResponseEntity.ok(medicoRepository.pesquisaPorNomeNativa(nome));
    }

    @PostMapping
    public ResponseEntity<Medico> create(@RequestBody Medico novoMedico){
        return ResponseEntity.ok(medicoRepository.save(novoMedico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> update(@PathVariable String id, @RequestBody Medico editMedico){
        Medico medico = medicoRepository.findById(id).orElse(new Medico());

        medico.setId(editMedico.getId());
        medico.setCrm(editMedico.getCrm());
        medico.setNome(editMedico.getNome());
        medico.setEmail(editMedico.getEmail());

        return ResponseEntity.ok(medicoRepository.save(medico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        medicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
