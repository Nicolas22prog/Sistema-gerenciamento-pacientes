package com.sistemas.jakarta.service;

import com.sistemas.jakarta.dtos.CreateProfissionalDTO;
import com.sistemas.jakarta.entity.Profissional;
import com.sistemas.jakarta.repository.ProfissionalRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author Nicolas
 */
@RequestScoped
public class ProfissionalService implements Serializable{

    private static final Logger LOG = Logger.getLogger(ProfissionalService.class.getName());

    
    @Inject
    private ProfissionalRepository profissionalRepository;
    
    public long cadastrarProfissional(CreateProfissionalDTO request) throws Exception{
        if(request == null){
            throw new Exception("Dados do profissional precisam ser preenchidos!");
        }
        
        Optional<Profissional> exist = profissionalRepository.buscarProfissionalPorRegistro(request.getRegistro());
        
        if(exist.isPresent()){
        
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
}
