package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "evolucao")
public class Evolucao {

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Paciente pacienteId;
    private Profissional profissionalId;
    private OffsetDateTime dataEvolução;

    public Evolucao(Long id, Paciente pacienteId, Profissional profissionalId, OffsetDateTime dataEvolução) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.profissionalId = profissionalId;
        this.dataEvolução = dataEvolução;
    }

    public Long getId() {
        return id;
    }

    public Paciente getPacienteId() {
        return pacienteId;
    }

    public Profissional getProfissionalId() {
        return profissionalId;
    }

    public OffsetDateTime getDataEvolução() {
        return dataEvolução;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPacienteId(Paciente pacienteId) {
        this.pacienteId = pacienteId;
    }

    public void setProfissionalId(Profissional profissionalId) {
        this.profissionalId = profissionalId;
    }

    public void setDataEvolução(OffsetDateTime dataEvolução) {
        this.dataEvolução = dataEvolução;
    }
    
    
    
}
