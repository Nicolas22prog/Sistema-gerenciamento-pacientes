package com.sistemas.jakarta.controllers;

import com.sistemas.jakarta.entity.Atendimentos;
import com.sistemas.jakarta.service.AtendimentoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

/**
 * @author Nicolas
 */
@Named
@RequestScoped
public class AntendimentoController {

    @Inject
    AtendimentoService atendimentoService;
    
    private List<Atendimentos> atendimentos;

    public void init() {
        atendimentos = atendimentoService.listarTodos();
    }

    public List<Atendimentos> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimentos> atendimentos) {
        this.atendimentos = atendimentos;
    }
    
    
    
}
