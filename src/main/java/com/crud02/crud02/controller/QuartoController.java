package com.crud02.crud02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crud02.crud02.model.Quarto;
import com.crud02.crud02.service.QuartoService;

@RestController
@RequestMapping("/api/v1/quartos")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    // read -> busca todos os quartos
    @GetMapping
    public ResponseEntity<List<Quarto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(quartoService.findAllQuartos());
    }

    // read -> busca um quarto pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Quarto> findById(@PathVariable Long id) {
        Optional<Quarto> quarto = quartoService.findById(id);
        return quarto.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                     .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // create -> cria um novo quarto
    @PostMapping
    public ResponseEntity<Quarto> create(@RequestBody Quarto quarto){
        return ResponseEntity.status(HttpStatus.CREATED).body(quartoService.save(quarto));
    }

    // update -> atualiza um quarto pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Quarto> update(@PathVariable Long id, @RequestBody Quarto quarto) {
        Optional<Quarto> existingQuarto = quartoService.findById(id);
        if (existingQuarto.isPresent()) {
            quarto.setId(id);
            return ResponseEntity.status(HttpStatus.OK).body(quartoService.update(quarto));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // delete -> deleta um quarto pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Quarto> quarto = quartoService.findById(id);
        if (quarto.isPresent()) {
            quartoService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}