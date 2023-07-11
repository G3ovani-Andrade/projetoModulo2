package com.MedicineInc.LABMedication.controller;

import com.MedicineInc.LABMedication.entity.UsuarioEntity;
import com.MedicineInc.LABMedication.service.UsuarioService;
import jakarta.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity cadastrarUsuarios(@RequestBody UsuarioEntity novoUsuario){
        try {
            return new ResponseEntity(this.service.cadastrarUsuario(novoUsuario),HttpStatus.CREATED);
        }catch (DataIntegrityViolationException e){
            return new ResponseEntity("Cpf já Cadastrado",HttpStatus.CONFLICT);
       } catch (ConstraintViolationException e){
            String erro = "";
            for (ConstraintViolation<?> c : e.getConstraintViolations()){
                erro += c.getMessage() +"\n";
            }
            return new ResponseEntity(erro,HttpStatus.BAD_REQUEST);
        }
    }

}
