package com.crud02.crud02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud02.crud02.model.Quarto;
import com.crud02.crud02.service.QuartoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/quartos")
public class QuartoController {
    @Autowired
    private QuartoService quartoService;

    @GetMapping
    public ResponseEntity<List<Quarto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(quartoService.findAllQuartos());
    }    

    @PostMapping
    public ResponseEntity<Quarto> create(@RequestBody Quarto quarto){
        return ResponseEntity.status(HttpStatus.CREATED).body(quartoService.save(quarto));
    }    

    
}