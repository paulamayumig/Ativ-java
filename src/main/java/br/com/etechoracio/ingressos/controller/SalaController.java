package br.com.etechoracio.ingressos.controller;

import br.com.etechoracio.ingressos.entity.Filme;
import br.com.etechoracio.ingressos.entity.Sala;
import br.com.etechoracio.ingressos.enums.ClassificacaoIndicativaEnum;
import br.com.etechoracio.ingressos.enums.SimNaoEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class SalaController {

    private List<Long> idsExistentes = new ArrayList<>(List.of(1L, 2L, 3L, 4L, 5L));

    private Long gerarIdAleatorio() {
        return new Random().nextLong(5) + 1;
    }

    // Implementação do seu código
    @GetMapping
    public List<Sala> listar(){
        Sala sala1 = Sala.builder()
                .id(1L)
                .nome("Matrix")
                .preco(20F)
                .dataExclusao(null)
                .build();
        Sala sala2 = Sala.builder()
                .id(2L)
                .nome("pw")
                .preco(0F)
                .dataExclusao(null)
                .build();
        Sala sala3 = Sala.builder()
                .id(3L)
                .nome("bd")
                .preco(40F)
                .dataExclusao(null)
                .build();
        Sala sala4 = Sala.builder()
                .id(4L)
                .nome("pam")
                .preco(6F)
                .dataExclusao(null)
                .build();
        Sala sala5 = Sala.builder()
                .id(5L)
                .nome("DS")
                .preco(10F)
                .dataExclusao(null)
                .build();
        return List.of(sala1, sala2, sala3, sala4, sala5); // retornar lista de salas
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> buscarPorId(@PathVariable Long id){
        if(idsExistentes.contains(id)) {
            Sala sala1 = Sala.builder()
                    .id(id)
                    .nome("Matrix")
                    .preco(20F)
                    .dataExclusao(null)
                    .build();
            return ResponseEntity.ok(sala1);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Sala> inserir(@RequestBody Sala sala){
        sala.setId(gerarIdAleatorio());
        if(sala.getPreco() > 0){
            if(sala.getNome() == sala.getNome()){
                return ResponseEntity.status(HttpStatus.CREATED).body(sala);
            }
            else{
                return ResponseEntity.badRequest().build();
            }
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    } // inserção de sala


    @PutMapping("/{id}")
    public ResponseEntity<Sala> buscar(@RequestBody Sala sala,
                                           @PathVariable Long id){
        if(idsExistentes.contains(id)) {
            return ResponseEntity.ok(sala);
        }
        return ResponseEntity.notFound().build();
    } // Buscar sala por ID

    @PutMapping("/{id}")
    public ResponseEntity<Sala> atualizar(@RequestBody Sala sala,
                                           @PathVariable Long id,
                                            @PathVariable String nome, @PathVariable float preco ){
        if(idsExistentes.contains(id)) {
            return ResponseEntity.ok(sala);
        }
        else if( sala.getPreco() <= 0){
            return ResponseEntity.badRequest().build();
        }
        else if( sala.getNome() == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.notFound().build();

    } // atualizar sala por ID

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if(idsExistentes.contains(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}
