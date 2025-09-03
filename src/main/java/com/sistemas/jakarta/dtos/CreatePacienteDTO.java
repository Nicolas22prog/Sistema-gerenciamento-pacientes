package com.sistemas.jakarta.dtos;

import java.time.OffsetDateTime;


/**
 * @author Nicolas
 */

public class CreatePacienteDTO {
    
    private String nome;
    private Long cpf;
    private String endereco;
    private String email;
    private OffsetDateTime dataNasc;
    private OffsetDateTime dataInicio;

    public CreatePacienteDTO() {
    }

    public CreatePacienteDTO(String nome, Long cpf, String endereco, String email, OffsetDateTime dataNasc, OffsetDateTime dataInicio) {
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

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
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

    public OffsetDateTime getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(OffsetDateTime dataNasc) {
        this.dataNasc = dataNasc;
    }

    public OffsetDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(OffsetDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }
    
    
}
