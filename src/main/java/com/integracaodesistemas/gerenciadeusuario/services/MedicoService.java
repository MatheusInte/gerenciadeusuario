package com.integracaodesistemas.gerenciadeusuario.services;

import com.integracaodesistemas.gerenciadeusuario.entities.Medico;
import com.integracaodesistemas.gerenciadeusuario.entities.Paciente;
import com.integracaodesistemas.gerenciadeusuario.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> listarMedicos(){
        return medicoRepository.findAll();
    }

    public Optional<Medico> buscarPorId(Long id){
        return medicoRepository.findById(id);
    }

    public Optional<Medico> buscarPorCrm(String crm){
        return medicoRepository.findByCrm(crm);
    }

    public Medico salvarMedico(Medico medico){
        return medicoRepository.save(medico);
    }

    public void deletarMedico(Long id){
        medicoRepository.deleteById(id);
    }
}
