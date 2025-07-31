package com.crud02.crud02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.crud02.crud02.model.Hospede;
import com.crud02.crud02.service.HospedeService;

@RestController
@RequestMapping("/api/v1/hospedes")
public class HospedeController {
    @Autowired
    private HospedeService hospedeService;

    @GetMapping
    public ResponseEntity<List<Hospede>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(hospedeService.findAllHospedes());
    }    

    @PostMapping
    public ResponseEntity<Hospede> create(@RequestBody Hospede hospede){
        return ResponseEntity.status(HttpStatus.CREATED).body(hospedeService.save(hospede));
    }    
}