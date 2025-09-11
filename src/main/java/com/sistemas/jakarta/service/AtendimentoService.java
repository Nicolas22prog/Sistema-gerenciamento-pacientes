package com.sistemas.jakarta.service;

import com.sistemas.jakarta.dtos.CreateAtendimentoDTO;
import com.sistemas.jakarta.dtos.UpdateAtendimentoDTO;
import com.sistemas.jakarta.entity.Atendimentos;
import com.sistemas.jakarta.entity.Paciente;
import com.sistemas.jakarta.entity.Profissional;
import com.sistemas.jakarta.repository.AtendimentoRepository;
import com.sistemas.jakarta.repository.CadastroPacienteRepository;
import com.sistemas.jakarta.repository.ProfissionalRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class AtendimentoService {

    @Inject
    private AtendimentoRepository atendimentoRepository;

    @Inject
    private CadastroPacienteRepository pacienteRepository;

    @Inject
    private ProfissionalRepository profissionalRepository;

    public Long criarAtendimento(CreateAtendimentoDTO dto) throws Exception {
        Profissional profissional = profissionalRepository.buscarProfissionalPorId(dto.getProfissionalId())
                .orElseThrow(() -> new Exception("Profissional não encontrado"));

        Paciente paciente = pacienteRepository.findByCpf(dto.getPacienteId())
                .orElseThrow(() -> new Exception("Paciente não encontrado"));

        Atendimentos atendimento = new Atendimentos();
        atendimento.setProfissional(profissional);
        atendimento.setPaciente(paciente);
        atendimento.setDataHora(dto.getDataHora());
        atendimento.setDescricao(dto.getDescricao());

        atendimentoRepository.salvar(atendimento);
        return atendimento.getId();
    }

    public Atendimentos atualizarAtendimento(Long id, UpdateAtendimentoDTO dto) throws Exception {
        Atendimentos atendimento = atendimentoRepository.findById(id)
                .orElseThrow(() -> new Exception("Atendimento não encontrado"));

        if (dto.getDescricao() != null) atendimento.setDescricao(dto.getDescricao());
        if (dto.getDataHora() != null) atendimento.setDataHora(dto.getDataHora());

        return atendimentoRepository.atualizar(atendimento);
    }

    public List<Atendimentos> listarTodos() {
        return atendimentoRepository.findAll();
    }

    public Optional<Atendimentos> buscarPorId(Long id) {
        return atendimentoRepository.findById(id);
    }

    public void removerAtendimento(Long id) throws Exception {
        if (atendimentoRepository.findById(id).isEmpty()) {
            throw new Exception("Atendimento não encontrado");
        }
        atendimentoRepository.remover(id);
    }
}
