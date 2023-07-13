package com.MedicineInc.LABMedication.service;


import com.MedicineInc.LABMedication.dto.*;
import com.MedicineInc.LABMedication.entity.UsuarioEntity;
import com.MedicineInc.LABMedication.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public UsuarioResponseDto cadastrarUsuario(UsuarioCadastroDto novoUsuario) {
        UsuarioEntity usuario = new UsuarioEntity();
        BeanUtils.copyProperties(novoUsuario, usuario);
        usuario = this.repository.save(usuario);
        UsuarioResponseDto responseDto = new UsuarioResponseDto();
        BeanUtils.copyProperties(usuario, responseDto);
        return responseDto;
    }

    public UsuarioResponseDto atualizarUsuario(Long id, UsuarioAtualizacaoDto usuarioAtualizado) {
        UsuarioEntity usuarioDb = this.repository.findById(id).get();//pegar o usuario com id no banco
        if (usuarioDb.getId() == null || usuarioDb.getId() < 0) { //checar se ele existe
            new Exception("Usuario não existe");
        }
        BeanUtils.copyProperties(usuarioAtualizado, usuarioDb);//copia os dados do usuarioAtualizado e coloca no novo usuario
        usuarioDb = repository.save(usuarioDb); //receber o retorno do banco
        UsuarioResponseDto response = new UsuarioResponseDto();// novo usuario do tipo response para retornar
        BeanUtils.copyProperties(usuarioDb, response);//copiando os atributos usuario que vem do banco para o response do
        response.setSenha(usuarioDb.getSenha());//setando a senha para o response que nao existe no UsuarioAtualizacaoDto
        return response;
    }

    public UsuarioResponseDto atualizarSenhaUsuario(Long id, UsuarioAtualizacaoSenhaDto usuarioSenhaAtualizado) throws Exception {
        UsuarioEntity usuarioDb = this.repository.findById(id).get();//pegar o usuario com id no banco
        if(!usuarioDb.getSenha().equals(usuarioSenhaAtualizado.getSenhaAntiga())){//comparar a senha do banco com a senha fornecida
           throw new Exception("A senha fornecida está incorreta");
        }
        usuarioDb.setSenha(usuarioSenhaAtualizado.getSenhaNova());//atualizar a senha objeto que veio do banco
        usuarioDb = this.repository.save(usuarioDb);//salvar o objeto com a senha atualizada no banco
        UsuarioResponseDto response = new UsuarioResponseDto();//criar um novo retorno
        BeanUtils.copyProperties(usuarioDb,response);//passar as propriedade para o novo retorno
        return response;
    }
}
