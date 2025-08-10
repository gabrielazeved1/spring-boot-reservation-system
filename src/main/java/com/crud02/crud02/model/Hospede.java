package com.crud02.crud02.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Hospede {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "status", length = 10, columnDefinition = "VARCHAR(10) DEFAULT 'ATIVO'")
    private String status = "ATIVO";

    @JsonManagedReference("hospede-reservas")
    @OneToMany(mappedBy = "hospede", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();
}