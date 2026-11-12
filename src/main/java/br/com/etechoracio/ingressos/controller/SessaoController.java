package br.com.etechoracio.ingressos.controller;


import br.com.etechoracio.ingressos.entity.Sessao;
import br.com.etechoracio.ingressos.repository.SessaoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {

    @Autowired
    private SessaoRepository sessaorepository;

    @GetMapping
    public ResponseEntity<List<Sessao>> Listar(){
        return ResponseEntity.ok(sessaorepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sessao> buscarPorId(@PathVariable Long id){
        var sessao = sessaorepository.findById(id);
        if(sessao.isPresent()){
            return ResponseEntity.ok(sessao.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Sessao> cadastrar(@RequestBody Sessao sessao) {
        sessao = sessaorepository.save(sessao);
        return ResponseEntity.status(HttpStatus.CREATED).body(sessao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sessao> atualizar(
            @RequestBody Sessao sessao,
            @PathVariable Long id) {

        if (!sessaorepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        sessao.setId(id);
        sessao = sessaorepository.save(sessao);

        return ResponseEntity.ok(sessao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        if (!sessaorepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        sessaorepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}

