package com.sistemas.jakarta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "evolucao")
public class Evolucao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    private OffsetDateTime dataEvolucao;

    public Evolucao() {}

    public Evolucao(Paciente paciente, Profissional profissional, OffsetDateTime dataEvolucao) {
        this.paciente = paciente;
        this.profissional = profissional;
        this.dataEvolucao = dataEvolucao;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Profissional getProfissional() { return profissional; }
    public void setProfissional(Profissional profissional) { this.profissional = profissional; }

    public OffsetDateTime getDataEvolucao() { return dataEvolucao; }
    public void setDataEvolucao(OffsetDateTime dataEvolucao) { this.dataEvolucao = dataEvolucao; }
}
