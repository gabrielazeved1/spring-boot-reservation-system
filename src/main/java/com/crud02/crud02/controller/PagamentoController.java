package com.crud02.crud02.controller;

import com.crud02.crud02.model.Pagamento;
import com.crud02.crud02.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<List<Pagamento>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pagamentoService.findAllPagamentos());
    }

    @PostMapping
    public ResponseEntity<Pagamento> create(@RequestBody Pagamento pagamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.save(pagamento));
    }
    
    // Você pode adicionar outros métodos como GET por ID, PUT e DELETE aqui
}