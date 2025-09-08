package com.sistemas.jakarta.repository;

import com.sistemas.jakarta.entity.Paciente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author Nicolas
 */
@ApplicationScoped
public class CadastroPacienteRepository {

    @PersistenceContext(unitName = "GerenciadorPacientePU")
    private EntityManager em;

    // Buscar paciente por CPF
    public Optional<Paciente> findByCpf(Long cpf) {
        return em.createQuery("SELECT p FROM Paciente p WHERE p.cpf = :cpf", Paciente.class)
                .setParameter("cpf", cpf)
                .setMaxResults(1)
                .getResultStream()
                .findFirst();
    }

    // Buscar todos os pacientes
    public List<Paciente> findAll() {
        return em.createQuery("SELECT p FROM Paciente p", Paciente.class)
                .getResultList();
    }

    // Salvar paciente
    @Transactional
    public void salvarPaciente(Paciente paciente) {
        em.persist(paciente);
        em.flush(); // garante que o ID seja gerado imediatamente
    }

    // Atualizar paciente
    @Transactional
    public Paciente updatePaciente(Paciente paciente) {
        Paciente updated = em.merge(paciente);
        em.flush();
        return updated;
    }

    // Deletar paciente por CPF
    @Transactional
    public void removePaciente(Long cpf) {
        em.createQuery("DELETE FROM Paciente p WHERE p.cpf = :cpf")
                .setParameter("cpf", cpf)
                .executeUpdate();
    }
}
