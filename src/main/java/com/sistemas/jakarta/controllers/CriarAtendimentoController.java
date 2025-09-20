package com.sistemas.jakarta.controllers;

import com.sistemas.jakarta.dtos.CreateAtendimentoDTO;
import com.sistemas.jakarta.service.AtendimentoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * @author Nicolas
 */
@Named
@RequestScoped
public class CriarAtendimentoController {

    @Inject
    AtendimentoService atendimentoService;

    private CreateAtendimentoDTO atendimento;

    public void salvar() throws Exception {
        try {
            atendimentoService.criarAtendimento(atendimento);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao criar atendimento!");
        }
    }

    public CreateAtendimentoDTO getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(CreateAtendimentoDTO atendimento) {
        this.atendimento = atendimento;
    }

}
