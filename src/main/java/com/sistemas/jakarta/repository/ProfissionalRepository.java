package com.sistemas.jakarta.repository;

import com.sistemas.jakarta.entity.Profissional;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.io.Serializable;
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
}
