package com.sistemas.jakarta.repository;

import com.sistemas.jakarta.entity.Paciente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.Optional;

/**
 * @author Nicolas
 */
@ApplicationScoped
public class CadastroPacienteRepository {

    @PersistenceContext(unitName = "GerenciadorPacientePU")
    private EntityManager em;

    public Optional<Paciente> findByCpf(Long cpf) {
        return em.createQuery("SELECT p FROM Paciente p WHERE p.cpf = :cpf", Paciente.class)
                .setParameter("cpf", cpf)
                .setMaxResults(1)
                .getResultStream()
                .findFirst();
    }

    @Transactional
    public void salvarPaciente(Paciente paciente) {
        em.persist(paciente);
    }

    @Transactional
    public void updatePaciente(Paciente paciente) {
        em.merge(paciente);
    }

    @Transactional
    public void removePaciente(Long cpf) {
        em.createQuery("DELETE FROM Paciente p WHERE p.cpf = :cpf")
                .setParameter("cpf", cpf)
                .executeUpdate();
    }

}
