package com.crud02.crud02.service;

import java.util.List;
import java.util.Optional;
    
import com.crud02.crud02.model.Reserva;
    
    public interface ReservaService {
        Reserva save(Reserva reserva);

        List<Reserva> findAllReservas();
        Optional<Reserva> findById(Long id);
        Reserva update(Reserva reserva);
        void deleteById(Long id);
        
    }