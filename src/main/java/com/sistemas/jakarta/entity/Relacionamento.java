package com.sistemas.jakarta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "paceinte-profissional")
public class Relacionamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Paciente pacienteId;
    private Profissional proficonalId;
    private OffsetDateTime dateInicio;
    private OffsetDateTime dataFim;
    private String papel;

}
