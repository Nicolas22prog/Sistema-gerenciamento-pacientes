package com.sistemas.jakarta.service;

import com.sistemas.jakarta.dtos.CreateProfissionalDTO;
import com.sistemas.jakarta.dtos.UpdateProfissionalDTO;
import com.sistemas.jakarta.entity.Profissional;
import com.sistemas.jakarta.repository.ProfissionalRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author Nicolas
 */
@RequestScoped
public class ProfissionalService implements Serializable {

    private static final Logger LOG = Logger.getLogger(ProfissionalService.class.getName());

    @Inject
    private ProfissionalRepository profissionalRepository;

    public long cadastrarProfissional(CreateProfissionalDTO request) throws Exception {
        if (request == null) {
            throw new Exception("Dados do profissional precisam ser preenchidos!");
        }

        Optional<Profissional> exist = profissionalRepository.buscarProfissionalPorRegistro(request.getRegistro());

        if (exist.isPresent()) {

            throw new Exception("Profissional ja está cadastrado!");
        }
        Profissional profissional = new Profissional();

        profissional.setNome(request.getNome());
        profissional.setEspecialidade(request.getEspecialidade());
        profissional.setTipoRegistro(request.getTipoRegistro());
        profissional.setRegistro(request.getRegistro());
        profissional.setDataCriacao(request.getDataCriacao());

        profissionalRepository.salvarProfissional(profissional);
        return profissional.getId();
    }

    public Optional<Profissional> buscarPorId(Long id) {
        return profissionalRepository.buscarPorId(id);
    }

    // 🔍 Buscar por registro
    public Optional<Profissional> buscarPorRegistro(String registro) {
        return profissionalRepository.buscarProfissionalPorRegistro(registro);
    }

    // 📌 Listar todos
    public List<Profissional> listarTodos() {
        return profissionalRepository.buscarTodos();
    }

    // ✏️ Atualizar
    public Profissional atualizarProfissional(Long id, UpdateProfissionalDTO request) throws Exception {
        Optional<Profissional> exist = profissionalRepository.buscarPorId(id);
        if (exist.isEmpty()) {
            throw new Exception("Profissional não encontrado!");
        }

        Profissional profissional = exist.get();

        if (request.getNome() != null) {
            profissional.setNome(request.getNome());
        }
        if (request.getTipoRegistro() != null) {
            profissional.setTipoRegistro(request.getTipoRegistro());
        }
        if (request.getRegistro() != null) {
            profissional.setRegistro(request.getRegistro());
        }
        if (request.getEspecialidade() != null) {
            profissional.setEspecialidade(request.getEspecialidade());
        }
        if (request.getDataCriacao() != null) {
            profissional.setDataCriacao(request.getDataCriacao());
        }

        return profissionalRepository.atualizarProfissional(profissional);
    }

    // ❌ Remover
    public void removerProfissional(Long id) throws Exception {
        Optional<Profissional> exist = profissionalRepository.buscarPorId(id);
        if (exist.isEmpty()) {
            throw new Exception("Profissional não encontrado para exclusão!");
        }
        profissionalRepository.apagarProfissional(id);
    }
}
