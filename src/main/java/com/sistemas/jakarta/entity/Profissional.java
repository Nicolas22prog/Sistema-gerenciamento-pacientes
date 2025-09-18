package com.sistemas.jakarta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.List;

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

    @OneToMany(mappedBy = "profissional")
    private List<Atendimentos> atendimentos;

    @OneToMany(mappedBy = "profissional")
    private List<Evolucao> evolucoes;

    public Profissional() {}

    public Profissional(String nome, String tipoRegistro, String registro, String especialidade, OffsetDateTime dataCriacao) {
        this.nome = nome;
        this.tipoRegistro = tipoRegistro;
        this.registro = registro;
        this.especialidade = especialidade;
        this.dataCriacao = dataCriacao;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipoRegistro() { return tipoRegistro; }
    public void setTipoRegistro(String tipoRegistro) { this.tipoRegistro = tipoRegistro; }

    public String getRegistro() { return registro; }
    public void setRegistro(String registro) { this.registro = registro; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public OffsetDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(OffsetDateTime dataCriacao) { this.dataCriacao = dataCriacao; }

    public List<Atendimentos> getAtendimentos() { return atendimentos; }
    public void setAtendimentos(List<Atendimentos> atendimentos) { this.atendimentos = atendimentos; }

    public List<Evolucao> getEvolucoes() { return evolucoes; }
    public void setEvolucoes(List<Evolucao> evolucoes) { this.evolucoes = evolucoes; }
}
