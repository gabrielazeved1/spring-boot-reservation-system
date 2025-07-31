package com.crud02.crud02.service;

import java.util.List;
import java.util.Optional;

import com.crud02.crud02.model.Hospede;

public interface HospedeService {
    Hospede save(Hospede hospede);
    List<Hospede> findAllHospedes();
    Optional<Hospede> findById(Long id);
    Hospede update(Hospede hospede);
    void deleteById(Long id);
}