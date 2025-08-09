package com.crud02.crud02.service;

import com.crud02.crud02.model.Pagamento;
import java.util.List;
import java.util.Optional;

public interface PagamentoService {
    Pagamento save(Pagamento pagamento);
    List<Pagamento> findAllPagamentos();
    Optional<Pagamento> findById(Long id);
    Pagamento update(Pagamento pagamento);
    void deleteById(Long id);
}