package com.sistemas.jakarta.repository;

import com.sistemas.jakarta.entity.Atendimentos;
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
public class AtendimentoRepository {

    @PersistenceContext(unitName = "GerenciadorPacientePU")
    private EntityManager em;

    public Optional<Atendimentos> findById(Long id) {
        return Optional.ofNullable(em.find(Atendimentos.class, id));
    }

    public List<Atendimentos> findAll() {
        return em.createQuery("SELECT a FROM Atendimento a", Atendimentos.class)
                .getResultList();
    }

    @Transactional
    public Atendimentos salvar(Atendimentos atendimento) {
        em.persist(atendimento);
        em.flush();
        return atendimento;
    }

    @Transactional
    public Atendimentos atualizar(Atendimentos atendimento) {
        return em.merge(atendimento);
    }

    @Transactional
    public void remover(Long id) {
        Atendimentos atendimento = em.find(Atendimentos.class, id);
        if (atendimento != null) {
            em.remove(atendimento);
        }
    }
}