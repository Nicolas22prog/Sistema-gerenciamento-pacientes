package com.sistemas.jakarta.repository;

import com.sistemas.jakarta.entity.Profissional;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Optional;
/**
 * @author Nicolas
 */
@RequestScoped
public class ProfissionalRepository implements Serializable{

     @PersistenceContext(unitName = "GerenciadorPacientePU")
    private EntityManager em;
     
     public Optional<Profissional> buscarProficionalPorRegistro(String registro){
         return em.createQuery("SELECT p FROM Profissional WHERER p.registro = :registro", Profissional.class)
                  .setParameter("registro", registro)
                 .setMaxResults(1)
                 .getResultStream()
                 .findFirst();
     }
     
     public void salvarProfissional(Profissional profissional){
         em.persist(profissional);
     }
}
