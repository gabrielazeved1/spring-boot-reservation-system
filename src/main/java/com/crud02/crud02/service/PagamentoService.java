package com.crud02.crud02.service;

import java.util.List;
import java.util.Optional;

import com.crud02.crud02.model.Pagamento;

public interface PagamentoService {
    Pagamento save(Pagamento pagamento);
    List<Pagamento> findAllPagamentos();
    Optional<Pagamento> findById(Long id);
    Pagamento update(Pagamento pagamento);
    void deleteById(Long id);
}