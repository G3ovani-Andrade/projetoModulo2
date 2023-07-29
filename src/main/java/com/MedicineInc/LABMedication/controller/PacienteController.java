package com.MedicineInc.LABMedication.controller;

import com.MedicineInc.LABMedication.dto.PacienteCadastroDTO;
import com.MedicineInc.LABMedication.dto.PacienteResponseDTO;
import com.MedicineInc.LABMedication.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> cadastrarPaciente(@RequestBody @Valid PacienteCadastroDTO novoPaciente){
            return new ResponseEntity<PacienteResponseDTO>(this.service.cadastrarPaciente(novoPaciente), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{identificador}")
    public ResponseEntity<PacienteResponseDTO> atualizarPaciente(@PathVariable Long identificador, @RequestBody @Valid PacienteCadastroDTO pacienteAtualizado){
            return new ResponseEntity(this.service.atualizarPaciente(identificador,pacienteAtualizado),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> buscarPacientes(@RequestParam(required = false)String nome){
        return new ResponseEntity<>(this.service.buscarPacientes(nome),HttpStatus.OK);
    }

    @GetMapping("/{identificador}")
    public ResponseEntity<PacienteResponseDTO> buscarPacientePorId(@PathVariable Long identificador){
            return new ResponseEntity<PacienteResponseDTO>(this.service.buscarPacientePorId(identificador),HttpStatus.OK);
    }


    @DeleteMapping("/{identificador}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long identificador){
        this.service.deletarPaciente(identificador);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
