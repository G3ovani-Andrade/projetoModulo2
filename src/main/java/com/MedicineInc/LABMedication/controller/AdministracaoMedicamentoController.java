package com.MedicineInc.LABMedication.controller;

import com.MedicineInc.LABMedication.dto.AdministracaoMedicamentoCadastroDTO;
import com.MedicineInc.LABMedication.dto.AdministracaoMedicamentoResponseDTO;
import com.MedicineInc.LABMedication.service.AdministracaoMedicamentoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

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

}
