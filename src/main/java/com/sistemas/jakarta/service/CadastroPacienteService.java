package com.sistemas.jakarta.service;

import com.sistemas.jakarta.dtos.CreatePacienteDTO;
import com.sistemas.jakarta.entity.Paciente;
import com.sistemas.jakarta.repository.CadastroPacienteRepository;
import jakarta.inject.Inject;


/**
 * @author Nicolas
 */

public class CadastroPacienteService {

    @Inject
    private CadastroPacienteRepository pacienteRepository;
    
    public long cadastrarPaciente(CreatePacienteDTO request) throws Exception{
        if(request == null){
            throw new Exception("Dados do paciente precisam ser preenchidos!");
        }
        
        Paciente paciente = new Paciente();
        
        paciente.setNome(request.getNome());
        paciente.setCpf(request.getCpf());
        paciente.setEndereco(request.getEndereco());
        paciente.setDataNasc(request.getDataNasc());
        paciente.setDataInicio(request.getDataInicio());
        pacienteRepository.salvarPaciente(paciente);
        
        return paciente.getId();
    }
    
    
}
