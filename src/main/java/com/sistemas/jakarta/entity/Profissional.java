package com.sistemas.jakarta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "profissional")
public class Profissional {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tipoRegistro;
    private String registro;
    private String especialidade;
    private OffsetDateTime dataCriacao;

    public Profissional(Long id, String nome, String tipoRegistro, String registro, String especialidade, OffsetDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.tipoRegistro = tipoRegistro;
        this.registro = registro;
        this.especialidade = especialidade;
        this.dataCriacao = dataCriacao;
    }

    public Profissional() {
    }

    
    
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public String getRegistro() {
        return registro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public OffsetDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setDataCriacao(OffsetDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    
}
