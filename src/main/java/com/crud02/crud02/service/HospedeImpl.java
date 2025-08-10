package com.crud02.crud02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud02.crud02.model.Hospede;
import com.crud02.crud02.repository.HospedeRepository;

@Service
public class HospedeImpl implements HospedeService{

    @Autowired
    private HospedeRepository hospedeRepository;

    @Override
    public Hospede save(Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    @Override
    public List<Hospede> findAllHospedes() {
        return hospedeRepository.findAll();
    }

    @Override
    public Optional<Hospede> findById(Long id) {
        return hospedeRepository.findById(id);
    }

    @Override
    public Hospede update(Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    @Override
    public void deleteById(Long id) {
        hospedeRepository.deleteById(id);
    }
}