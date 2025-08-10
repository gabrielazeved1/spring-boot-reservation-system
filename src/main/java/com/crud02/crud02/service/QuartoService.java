package com.crud02.crud02.service;

import java.util.List;
import java.util.Optional;

import com.crud02.crud02.model.Quarto;

public interface QuartoService {
    Quarto save(Quarto quarto);
    List<Quarto> findAllQuartos();
    Optional<Quarto> findById(Long id);
    Quarto update(Quarto quarto);
    void deleteById(Long id);
}