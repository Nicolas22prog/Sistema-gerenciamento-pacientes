package com.sistemas.jakarta.repository;

import com.sistemas.jakarta.entity.Profissional;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author Nicolas
 */
@RequestScoped
public class ProfissionalRepository implements Serializable {

    @PersistenceContext(unitName = "GerenciadorPacientePU")
    private EntityManager em;

    public Optional<Profissional> buscarProfissionalPorRegistro(String registro) {
        return em.createQuery(
                "SELECT p FROM Profissional p WHERE p.registro = :registro", Profissional.class)
                .setParameter("registro", registro)
                .setMaxResults(1)
                .getResultStream()
                .findFirst();
    }

    @Transactional
    public Profissional salvarProfissional(Profissional profissional) {
        em.persist(profissional);
        em.flush(); // força INSERT imediato
        return profissional;
    }

    public List<Profissional> buscarTodos() {
        return em.createQuery("SELECT p FROM Profissional p", Profissional.class)
                .getResultList();
    }

    @Transactional
    public Profissional atualizarProfissional(Profissional profissional) {
        return em.merge(profissional);
    }

    @Transactional
    public void apagarProfissional(Long id) {
        Profissional profissional = em.find(Profissional.class, id);
        if (profissional != null) {
            em.remove(profissional);
        }
    }

    public Optional<Profissional> buscarPorId(Long id) {
        return Optional.ofNullable(em.find(Profissional.class, id));
    }

    public Optional<Profissional> buscarProfissionalPorId(Long profissionalId) {
       return em.createQuery("SELECT p FROM Profissional p WHERE p.id =:profissionalId",Profissional.class)
                .setParameter("profissionalId", profissionalId)
                .setMaxResults(1)
                .getResultStream()
                .findFirst();
    }
}
