package com.MedicineInc.LABMedication.controller;

import com.MedicineInc.LABMedication.dto.UsuarioAtualizacaoDTO;
import com.MedicineInc.LABMedication.dto.UsuarioAtualizacaoSenhaDTO;
import com.MedicineInc.LABMedication.dto.UsuarioCadastroDTO;
import com.MedicineInc.LABMedication.dto.UsuarioResponseDTO;
import com.MedicineInc.LABMedication.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrarUsuarios(@RequestBody @Valid UsuarioCadastroDTO novoUsuario) {
            return new ResponseEntity<>(this.service.cadastrarUsuario(novoUsuario), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{identificador}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuario(@PathVariable Long identificador, @RequestBody @Valid UsuarioAtualizacaoDTO usuarioAtualizado) {
            return new ResponseEntity<>(this.service.atualizarUsuario(identificador, usuarioAtualizado), HttpStatus.OK);
    }

    @PatchMapping(value = "/{identificador}/senha")
    public ResponseEntity<UsuarioResponseDTO> atualizarSenhaUsuario(@PathVariable Long identificador, @RequestBody @Valid UsuarioAtualizacaoSenhaDTO usuarioSenhaAtualizado) throws Exception {
           return new ResponseEntity<>(this.service.atualizarSenhaUsuario(identificador, usuarioSenhaAtualizado), HttpStatus.OK);
    }
}
