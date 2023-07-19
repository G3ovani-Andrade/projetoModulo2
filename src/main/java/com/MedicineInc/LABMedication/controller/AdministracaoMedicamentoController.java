package com.MedicineInc.LABMedication.controller;

import com.MedicineInc.LABMedication.dto.AdministracaoMedicamentoAtualizacaoDto;
import com.MedicineInc.LABMedication.dto.AdministracaoMedicamentoCadastroDTO;
import com.MedicineInc.LABMedication.dto.AdministracaoMedicamentoBuscaDTO;
import com.MedicineInc.LABMedication.dto.AdministracaoMedicamentoResponseDTO;
import com.MedicineInc.LABMedication.service.AdministracaoMedicamentoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicamentos")
public class AdministracaoMedicamentoController {
    @Autowired
    private AdministracaoMedicamentoService service;

    @PostMapping
    public ResponseEntity<AdministracaoMedicamentoResponseDTO> cadastrarAdministracaoMedicamento(@RequestBody @Valid AdministracaoMedicamentoCadastroDTO medicamentoDTO){
        try {
            return new ResponseEntity(this.service.cadastrarAdministracaoMedicamento(medicamentoDTO), HttpStatus.CREATED);
        }catch (EntityNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{identificador}")
    public ResponseEntity<AdministracaoMedicamentoResponseDTO> atualizarAdimistracaoMedicamento(@PathVariable Long identificador,@RequestBody @Valid AdministracaoMedicamentoAtualizacaoDto medicamentoAtualizado){
        try {
            return new ResponseEntity<>(this.service.atualizarAdimistracaoMedicamento(identificador,medicamentoAtualizado), HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{identificador}")
    public ResponseEntity<AdministracaoMedicamentoBuscaDTO>  buscarAdministracaoMedicamento(@PathVariable Long identificador){
        try {
            return new ResponseEntity<AdministracaoMedicamentoBuscaDTO>(this.service.buscarAdministracaoMedicamento(identificador),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{identificador}")
    public ResponseEntity deletarAdministracaoMedicamento(@PathVariable Long identificador){
        try {
            this.service.deletarAdministracaoMedicamento(identificador);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch (EntityNotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
