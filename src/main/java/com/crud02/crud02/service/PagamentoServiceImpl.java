package com.crud02.crud02.service;

import com.crud02.crud02.model.Pagamento;
import com.crud02.crud02.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public Pagamento save(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @Override
    public List<Pagamento> findAllPagamentos() {
        return pagamentoRepository.findAll();
    }

    @Override
    public Optional<Pagamento> findById(Long id) {
        return pagamentoRepository.findById(id);
    }

    @Override
    public Pagamento update(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @Override
    public void deleteById(Long id) {
        pagamentoRepository.deleteById(id);
    }
}