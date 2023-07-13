package com.MedicineInc.LABMedication.controller;

import com.MedicineInc.LABMedication.dto.UsuarioAtualizacaoDto;
import com.MedicineInc.LABMedication.dto.UsuarioCadastroDto;
import com.MedicineInc.LABMedication.dto.UsuarioResponseDto;
import com.MedicineInc.LABMedication.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> cadastrarUsuarios(@RequestBody @Valid UsuarioCadastroDto novoUsuario) {
        try {
            return new ResponseEntity<>(this.service.cadastrarUsuario(novoUsuario), HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity("Cpf já Cadastrado", HttpStatus.CONFLICT);
        }

//        try {
//            return new ResponseEntity(this.service.cadastrarUsuario(novoUsuario),HttpStatus.CREATED);
//        }catch (DataIntegrityViolationException e){
//            return new ResponseEntity("Cpf já Cadastrado",HttpStatus.CONFLICT);
//       } catch (ConstraintViolationException e){
//            String erro = "";
//            for (ConstraintViolation<?> c : e.getConstraintViolations()){
//                erro += c.getMessage() + c.getPropertyPath()+"\n";
//            }
//            return new ResponseEntity(erro,HttpStatus.BAD_REQUEST);
//        }
    }

    @PutMapping(value = "/{identificador}")
    public ResponseEntity<UsuarioResponseDto> atualizarUsuario(@PathVariable Long identificador, @RequestBody @Valid UsuarioAtualizacaoDto usuarioAtualizado) {
        try {
            return new ResponseEntity(this.service.atualizarUsuario(identificador, usuarioAtualizado), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity("Cpf já Cadastrado", HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
