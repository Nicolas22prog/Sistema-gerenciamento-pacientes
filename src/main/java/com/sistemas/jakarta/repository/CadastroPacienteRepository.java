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
    
    public Optional<Paciente> findByCpf(Integer cpf){
        return em.createQuery("SELECT p FROM Pacientes WHERE p.cpf =: cpf",Paciente.class)
                .setParameter("cpf", cpf)
                .setMaxResults(1)
                .getResultStream()
                .findFirst();
    }
    
    @Transactional
    public void salvarPaciente(Paciente paciente){
        em.persist(paciente);
    }
}
