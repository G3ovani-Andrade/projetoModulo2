package com.MedicineInc.LABMedication.controller;

import com.MedicineInc.LABMedication.dto.AdministracaoMedicamentoAtualizacaoDTO;
import com.MedicineInc.LABMedication.dto.AdministracaoMedicamentoBuscaDTO;
import com.MedicineInc.LABMedication.dto.AdministracaoMedicamentoCadastroDTO;
import com.MedicineInc.LABMedication.dto.AdministracaoMedicamentoResponseDTO;
import com.MedicineInc.LABMedication.service.AdministracaoMedicamentoService;
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
            return new ResponseEntity(this.service.cadastrarAdministracaoMedicamento(medicamentoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{identificador}")
    public ResponseEntity<AdministracaoMedicamentoResponseDTO> atualizarAdimistracaoMedicamento(@PathVariable Long identificador,@RequestBody @Valid AdministracaoMedicamentoAtualizacaoDTO medicamentoAtualizado){
            return new ResponseEntity<>(this.service.atualizarAdimistracaoMedicamento(identificador,medicamentoAtualizado), HttpStatus.OK);
    }

    @GetMapping("/{identificador}")
    public ResponseEntity<AdministracaoMedicamentoBuscaDTO>  buscarAdministracaoMedicamento(@PathVariable Long identificador){
            return new ResponseEntity<AdministracaoMedicamentoBuscaDTO>(this.service.buscarAdministracaoMedicamento(identificador),HttpStatus.OK);
    }

    @DeleteMapping("/{identificador}")
    public ResponseEntity deletarAdministracaoMedicamento(@PathVariable Long identificador){
            this.service.deletarAdministracaoMedicamento(identificador);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
