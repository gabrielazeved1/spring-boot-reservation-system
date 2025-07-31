package com.crud02.crud02.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "numero", length = 10, nullable = false)
    private Integer numero;
    
    @Column(name = "tipo", length = 20)
    private String tipo;

    @Column(name = "preco", columnDefinition = "NUMERIC(10,2) DEFAULT 0.0")
    private Float preco;

    @OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL)
    private List  <Reserva> reservas = new ArrayList<>()  ;
}