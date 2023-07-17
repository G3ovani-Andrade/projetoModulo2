package com.MedicineInc.LABMedication.controller;

import com.MedicineInc.LABMedication.dto.PacienteCadastroDto;
import com.MedicineInc.LABMedication.dto.PacienteResponseDto;
import com.MedicineInc.LABMedication.service.PacienteService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<PacienteResponseDto> cadastrarPaciente(@RequestBody @Valid PacienteCadastroDto novoPaciente){
        try {
            return new ResponseEntity<PacienteResponseDto>(this.service.cadastrarPaciente(novoPaciente), HttpStatus.CREATED);
        }
        catch (DataIntegrityViolationException e) {
            return new ResponseEntity("Cpf já Cadastrado", HttpStatus.CONFLICT);
        }catch (EntityNotFoundException e){
            return new ResponseEntity("Endereço não encontrado", HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/{identificador}")
    public ResponseEntity<PacienteResponseDto> atualizarPaciente(@PathVariable Long identificador,@RequestBody @Valid PacienteCadastroDto pacienteAtualizado){
        try {
            return new ResponseEntity(this.service.atualizarPaciente(identificador,pacienteAtualizado),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }catch (DataIntegrityViolationException e) {
            return new ResponseEntity("Cpf já Cadastrado", HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
