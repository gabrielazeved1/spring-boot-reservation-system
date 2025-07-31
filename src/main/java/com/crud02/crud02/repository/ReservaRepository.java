package com.crud02.crud02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud02.crud02.model.Reserva;
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
}
