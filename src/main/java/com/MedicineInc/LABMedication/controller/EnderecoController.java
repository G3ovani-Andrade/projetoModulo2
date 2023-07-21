package com.MedicineInc.LABMedication.controller;

import com.MedicineInc.LABMedication.dto.EnderecoCadastroDTO;
import com.MedicineInc.LABMedication.dto.EnderecoResponseDto;
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
    public ResponseEntity<EnderecoResponseDto> cadastrarEndereco(@RequestBody @Valid EnderecoCadastroDTO endereco){
        return new ResponseEntity<EnderecoResponseDto>(this.service.cadastrarEndereco(endereco), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EnderecoResponseDto>> listarEnderecos(){
        return new ResponseEntity<List<EnderecoResponseDto>>(this.service.listarEnderecos(),HttpStatus.OK);
    }
}
