package com.sistemas.jakarta.service;

import com.sistemas.jakarta.dtos.CreatePacienteDTO;
import com.sistemas.jakarta.dtos.UpdatePacienteDTO;
import com.sistemas.jakarta.entity.Paciente;
import com.sistemas.jakarta.repository.CadastroPacienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * @author Nicolas
 */
@ApplicationScoped
public class CadastroPacienteService {

    @Inject
    private CadastroPacienteRepository pacienteRepository;

    // Cadastrar paciente
    public long cadastrarPaciente(CreatePacienteDTO request) throws Exception {
        if (request == null) {
            throw new Exception("Dados do paciente precisam ser preenchidos!");
        }

        Optional<Paciente> exist = pacienteRepository.findByCpf(request.getCpf());
        if (exist.isPresent()) {
            throw new Exception("Paciente já está cadastrado!");
        }

        Paciente paciente = new Paciente();
        paciente.setNome(request.getNome());
        paciente.setCpf(request.getCpf());
        paciente.setEndereco(request.getEndereco());
        paciente.setEmail(request.getEmail());
        paciente.setDataNasc(request.getDataNasc());
        paciente.setDataInicio(request.getDataInicio());

        pacienteRepository.salvarPaciente(paciente);
        return paciente.getId();
    }

    // Atualizar paciente
    public Paciente atualizarPaciente(Long cpf, UpdatePacienteDTO request) throws Exception {
    Optional<Paciente> pacienteOpt = pacienteRepository.findByCpf(cpf);
    if (pacienteOpt.isEmpty()) {
        throw new Exception("Paciente não encontrado!");
    }
    Paciente paciente = pacienteOpt.get();

    if (request.getNome() != null) paciente.setNome(request.getNome());
    if (request.getEndereco() != null) paciente.setEndereco(request.getEndereco());
    if (request.getEmail() != null) paciente.setEmail(request.getEmail());
    if (request.getDataNasc() != null) paciente.setDataNasc(request.getDataNasc());
    if (request.getDataInicio() != null) paciente.setDataInicio(request.getDataInicio());

    pacienteRepository.updatePaciente(paciente);
    return paciente;
}

    // Deletar paciente
    public void deletarPaciente(Long cpf) throws Exception {
        Optional<Paciente> exist = pacienteRepository.findByCpf(cpf);
        if (exist.isEmpty()) {
            throw new Exception("Paciente não encontrado!");
        }
        pacienteRepository.removePaciente(cpf);
    }

    // Buscar paciente por CPF
    public Optional<Paciente> buscarPacientePorCpf(Long cpf) {
        return pacienteRepository.findByCpf(cpf);
    }

    // Listar todos os pacientes
    public List<Paciente> listarTodosPacientes() {
        return pacienteRepository.findAll();
    }

}
