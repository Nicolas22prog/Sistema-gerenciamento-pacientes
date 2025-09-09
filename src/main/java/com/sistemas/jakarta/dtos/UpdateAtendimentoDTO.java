package com.sistemas.jakarta.dtos;

import java.time.LocalDateTime;

/**
 * @author Nicolas
 */
public class UpdateAtendimentoDTO {

    private String descricao;
    private LocalDateTime dataHora;

    public UpdateAtendimentoDTO() {
    }

    public UpdateAtendimentoDTO(String descricao, LocalDateTime dataHora) {
        this.descricao = descricao;
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
