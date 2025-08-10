package com.crud02.crud02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.crud02.crud02.model.Hospede;
import com.crud02.crud02.service.HospedeService;

@RestController
@RequestMapping("/api/v1/hospedes")
public class HospedeController {

    @Autowired
    private HospedeService hospedeService;

    // READ: Busca todos os hóspedes
    @GetMapping
    public ResponseEntity<List<Hospede>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(hospedeService.findAllHospedes());
    }

    // READ: Busca um hóspede pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Hospede> findById(@PathVariable Long id) {
        Optional<Hospede> hospede = hospedeService.findById(id);
        if (hospede.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(hospede.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // CREATE: Cria um novo hóspede
    @PostMapping
    public ResponseEntity<Hospede> create(@RequestBody Hospede hospede){
        return ResponseEntity.status(HttpStatus.CREATED).body(hospedeService.save(hospede));
    }

    // UPDATE: Atualiza um hóspede pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Hospede> update(@PathVariable Long id, @RequestBody Hospede hospede) {
        Optional<Hospede> existingHospede = hospedeService.findById(id);
        if (existingHospede.isPresent()) {
            hospede.setId(id);
            return ResponseEntity.status(HttpStatus.OK).body(hospedeService.update(hospede));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // DELETE: Deleta um hóspede pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Hospede> hospede = hospedeService.findById(id);
        if (hospede.isPresent()) {
            hospedeService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}