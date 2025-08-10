package com.crud02.crud02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crud02.crud02.model.Pagamento;
import com.crud02.crud02.service.PagamentoService;

@RestController
@RequestMapping("/api/v1/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    // read -> busca todos os pagamentos
    @GetMapping
    public ResponseEntity<List<Pagamento>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pagamentoService.findAllPagamentos());
    }

    // read -> busca um pagamento pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> findById(@PathVariable Long id) {
        Optional<Pagamento> pagamento = pagamentoService.findById(id);
        return pagamento.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // create -> cria um novo pagamento
    @PostMapping
    public ResponseEntity<Pagamento> create(@RequestBody Pagamento pagamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.save(pagamento));
    }

    // update -> atualiza um pagamento pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> update(@PathVariable Long id, @RequestBody Pagamento pagamento) {
        Optional<Pagamento> existingPagamento = pagamentoService.findById(id);
        if (existingPagamento.isPresent()) {
            pagamento.setId(id);
            return ResponseEntity.status(HttpStatus.OK).body(pagamentoService.update(pagamento));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // delete -> deleta um pagamento pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Pagamento> pagamento = pagamentoService.findById(id);
        if (pagamento.isPresent()) {
            pagamentoService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}