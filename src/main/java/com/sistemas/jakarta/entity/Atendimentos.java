package com.sistemas.jakarta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name ="atendimentos")
public class Atendimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(length = 255)
    private String descricao;

    @OneToOne
    @JoinColumn(name = "evolucao_id")
    private Evolucao evolucao;

    public Atendimentos() {}

    public Atendimentos(Profissional profissional, Paciente paciente, LocalDateTime dataHora, String descricao) {
        this.profissional = profissional;
        this.paciente = paciente;
        this.dataHora = dataHora;
        this.descricao = descricao;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Profissional getProfissional() { return profissional; }
    public void setProfissional(Profissional profissional) { this.profissional = profissional; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Evolucao getEvolucao() { return evolucao; }
    public void setEvolucao(Evolucao evolucao) { this.evolucao = evolucao; }
}
