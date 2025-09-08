package com.sistemas.jakarta.dtos;

import java.time.OffsetDateTime;


/**
 * @author Nicolas
 */

public class UpdateProfissionalDTO {
    private String nome;
    private String tipoRegistro;
    private String registro;
    private String especialidade;
    private OffsetDateTime dataCriacao;

    public UpdateProfissionalDTO() {
    }

    public UpdateProfissionalDTO(String nome, String tipoRegistro, String registro, String especialidade, OffsetDateTime dataCriacao) {
        this.nome = nome;
        this.tipoRegistro = tipoRegistro;
        this.registro = registro;
        this.especialidade = especialidade;
        this.dataCriacao = dataCriacao;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public OffsetDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(OffsetDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
