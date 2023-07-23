package com.MedicineInc.LABMedication.service;


import com.MedicineInc.LABMedication.dto.UsuarioAtualizacaoDTO;
import com.MedicineInc.LABMedication.dto.UsuarioAtualizacaoSenhaDTO;
import com.MedicineInc.LABMedication.dto.UsuarioCadastroDTO;
import com.MedicineInc.LABMedication.dto.UsuarioResponseDTO;
import com.MedicineInc.LABMedication.entity.UsuarioEntity;
import com.MedicineInc.LABMedication.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public UsuarioResponseDTO cadastrarUsuario(UsuarioCadastroDTO novoUsuario) {
        UsuarioEntity usuario = new UsuarioEntity();
        UsuarioResponseDTO responseDto = new UsuarioResponseDTO();
        BeanUtils.copyProperties(novoUsuario, usuario);
        try {
            usuario = this.repository.save(usuario);
        }catch(DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Cpf já cadastrado");
        }
        BeanUtils.copyProperties(usuario, responseDto);
        return responseDto;
    }

    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioAtualizacaoDTO usuarioAtualizado) {
        UsuarioEntity usuarioDb = this.repository.findById(id).orElseThrow(()->new EntityNotFoundException("Usuário não encontrado"));
        UsuarioResponseDTO response = new UsuarioResponseDTO();
        BeanUtils.copyProperties(usuarioAtualizado, usuarioDb);
        try {
            usuarioDb = repository.save(usuarioDb);
        }catch(DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Cpf já cadastrado");
        }
        BeanUtils.copyProperties(usuarioDb, response);
        response.setSenha(usuarioDb.getSenha());
        return response;
    }

    public UsuarioResponseDTO atualizarSenhaUsuario(Long id, UsuarioAtualizacaoSenhaDTO usuarioSenhaAtualizado) throws Exception {
        UsuarioEntity usuarioDb = this.repository.findById(id).orElseThrow(()->new EntityNotFoundException("Usuário não encontrado"));
        UsuarioResponseDTO response = new UsuarioResponseDTO();
        if(!usuarioDb.getSenha().equals(usuarioSenhaAtualizado.getSenhaAntiga())){
            throw new IllegalArgumentException("A senha fornecida está incorreta");
        }
        usuarioDb.setSenha(usuarioSenhaAtualizado.getSenhaNova());
        usuarioDb = this.repository.save(usuarioDb);
        BeanUtils.copyProperties(usuarioDb,response);
        return response;
    }
}
