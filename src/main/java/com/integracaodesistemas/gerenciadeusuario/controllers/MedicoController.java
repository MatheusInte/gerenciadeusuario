package com.integracaodesistemas.gerenciadeusuario.controllers;

import com.integracaodesistemas.gerenciadeusuario.entities.Medico;
import com.integracaodesistemas.gerenciadeusuario.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> listarMedicos(){
        return medicoService.listarMedicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscarMedicoPorId(@PathVariable long id){
        return medicoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/crm/{crm}")
    public ResponseEntity<Medico> buscarMedicoPorCrm(@PathVariable String crm){
        return medicoService.buscarPorCrm(crm)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Medico adicionarMedico(@RequestBody Medico medico){
        return medicoService.salvarMedico(medico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMedico(@PathVariable Long id){
        medicoService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }
}
