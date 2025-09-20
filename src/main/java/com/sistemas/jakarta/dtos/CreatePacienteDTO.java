package com.sistemas.jakarta.dtos;

import java.time.LocalDate;


/**
 * @author Nicolas
 */

public class CreatePacienteDTO {
    
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private LocalDate dataNasc;
    private LocalDate dataInicio;

    public CreatePacienteDTO() {
    }

    public CreatePacienteDTO(String nome, String cpf, String endereco, String email, LocalDate dataNasc, LocalDate dataInicio) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.dataNasc = dataNasc;
        this.dataInicio = dataInicio;
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    
    
}
