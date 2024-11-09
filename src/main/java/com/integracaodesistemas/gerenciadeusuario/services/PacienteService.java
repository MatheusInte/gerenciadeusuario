package com.integracaodesistemas.gerenciadeusuario.services;

import com.integracaodesistemas.gerenciadeusuario.entities.Paciente;
import com.integracaodesistemas.gerenciadeusuario.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> listarPacientes(){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscarPorId(Long id){
        return pacienteRepository.findById(id);
    }

    public Optional<Paciente> buscarPorCpf(String cpf){
        return pacienteRepository.findByCpf(cpf);
    }

    public Paciente salvarPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public void deletarPaciente(Long id){
        pacienteRepository.deleteById(id);
    }
 }
