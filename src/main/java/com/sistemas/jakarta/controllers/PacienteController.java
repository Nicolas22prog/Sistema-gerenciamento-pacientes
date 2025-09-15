package com.sistemas.jakarta.controllers;

import com.sistemas.jakarta.dtos.CreatePacienteDTO;
import com.sistemas.jakarta.service.CadastroPacienteService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 * @author Nicolas
 */
@Named("pacienteBean")
@RequestScoped
public class PacienteController implements Serializable {

    @Inject
    private CadastroPacienteService pacienteApiClient;

    private CreatePacienteDTO paciente = new CreatePacienteDTO();

    public void salvar() throws Exception {
        Long id = pacienteApiClient.cadastrarPaciente(paciente);
        System.out.println("Paciente criado com ID: " + id);
        paciente = new CreatePacienteDTO(); // limpa form
    }

    public CreatePacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(CreatePacienteDTO paciente) {
        this.paciente = paciente;
    }
}
