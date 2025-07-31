package com.crud02.crud02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud02.crud02.model.Quarto;
import com.crud02.crud02.repository.QuartoRepository;

@Service
public class QuartoImpl implements QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;


    public Quarto save(Quarto quarto) {
        return quartoRepository.save(quarto);
        
    }

    @Override
    public List<Quarto> findAllQuartos() {
        return quartoRepository.findAll();
        
        
    }

    @Override
    public Optional<Quarto> findById(Long id) {
        return quartoRepository.findById(id);
       
        
    }

    @Override
    public Quarto update(Quarto quarto) {
        return quartoRepository.save(quarto);
        
        
    }

    @Override
    public void deleteById(Long id) {
        quartoRepository.deleteById(id);
        
        
    }
    
}
