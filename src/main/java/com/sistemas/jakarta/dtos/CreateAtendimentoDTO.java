package com.sistemas.jakarta.dtos;

import java.time.LocalDateTime;

public class CreateAtendimentoDTO {

    private Long profissionalId;
    private Long pacienteId;
    private LocalDateTime dataHora;
    private String descricao;

    public CreateAtendimentoDTO() {
    }

    public CreateAtendimentoDTO(Long profissionalId, Long pacienteId, LocalDateTime dataHora, String descricao) {
        this.profissionalId = profissionalId;
        this.pacienteId = pacienteId;
        this.dataHora = dataHora;
        this.descricao = descricao;
    }

    public Long getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
