package com.sistemas.jakarta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private LocalDate dataNasc;
    private LocalDate dataInicio;

    @OneToMany(mappedBy = "paciente")
    private List<Atendimentos> atendimentos;

    @OneToMany(mappedBy = "paciente")
    private List<Evolucao> evolucoes;

    public Paciente() {}

    public Paciente(String nome, String cpf, String endereco, String email, LocalDate dataNasc, LocalDate dataInicio) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.dataNasc = dataNasc;
        this.dataInicio = dataInicio;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getDataNasc() { return dataNasc; }
    public void setDataNasc(LocalDate dataNasc) { this.dataNasc = dataNasc; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public List<Atendimentos> getAtendimentos() { return atendimentos; }
    public void setAtendimentos(List<Atendimentos> atendimentos) { this.atendimentos = atendimentos; }

    public List<Evolucao> getEvolucoes() { return evolucoes; }
    public void setEvolucoes(List<Evolucao> evolucoes) { this.evolucoes = evolucoes; }
}
