package com.sistemas.jakarta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "paciente-profissional")
public class Relacionamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Paciente pacienteId;
    private Profissional proficonalId;
    private OffsetDateTime dateInicio;
    private OffsetDateTime dataFim;
    private String papel;

    public Relacionamento(Paciente pacienteId, Profissional proficonalId, OffsetDateTime dateInicio, OffsetDateTime dataFim, String papel) {
        
        this.pacienteId = pacienteId;
        this.proficonalId = proficonalId;
        this.dateInicio = dateInicio;
        this.dataFim = dataFim;
        this.papel = papel;
    }

    public Relacionamento() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Paciente getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Paciente pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Profissional getProficonalId() {
        return proficonalId;
    }

    public void setProficonalId(Profissional proficonalId) {
        this.proficonalId = proficonalId;
    }

    public OffsetDateTime getDateInicio() {
        return dateInicio;
    }

    public void setDateInicio(OffsetDateTime dateInicio) {
        this.dateInicio = dateInicio;
    }

    public OffsetDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(OffsetDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    
    
    
}
