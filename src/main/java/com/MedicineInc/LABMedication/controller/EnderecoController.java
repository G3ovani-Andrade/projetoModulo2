package com.MedicineInc.LABMedication.controller;

import com.MedicineInc.LABMedication.dto.EnderecoCadastroDTO;
import com.MedicineInc.LABMedication.dto.EnderecoResponseDTO;
import com.MedicineInc.LABMedication.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;
    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> cadastrarEndereco(@RequestBody @Valid EnderecoCadastroDTO endereco){
        return new ResponseEntity<EnderecoResponseDTO>(this.service.cadastrarEndereco(endereco), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EnderecoResponseDTO>> listarEnderecos(){
        return new ResponseEntity<List<EnderecoResponseDTO>>(this.service.listarEnderecos(),HttpStatus.OK);
    }
}
