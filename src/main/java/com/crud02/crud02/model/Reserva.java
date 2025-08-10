package com.crud02.crud02.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "data_reserva")
    @Temporal(TemporalType.DATE)
    private Date data_checkout;

    @JsonBackReference("quarto-reservas")
    @ManyToOne
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;

    @JsonBackReference("hospede-reservas")
    @ManyToOne
    @JoinColumn(name = "hospede_id")
    private Hospede hospede;
}