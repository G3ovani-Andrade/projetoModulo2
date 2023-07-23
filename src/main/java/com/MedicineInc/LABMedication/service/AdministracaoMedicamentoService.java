package com.MedicineInc.LABMedication.service;

import com.MedicineInc.LABMedication.dto.*;
import com.MedicineInc.LABMedication.entity.MedicamentoEntity;
import com.MedicineInc.LABMedication.repository.MedicamentoRepository;
import com.MedicineInc.LABMedication.repository.PacienteRepository;
import com.MedicineInc.LABMedication.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdministracaoMedicamentoService {
    @Autowired
    private MedicamentoRepository repository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    public AdministracaoMedicamentoResponseDTO cadastrarAdministracaoMedicamento(AdministracaoMedicamentoCadastroDTO medicamentoDTO) {
        MedicamentoEntity medicamento = new MedicamentoEntity();
        AdministracaoMedicamentoResponseDTO response = new AdministracaoMedicamentoResponseDTO();
        this.usuarioRepository.findById(medicamentoDTO.getUsuario().getId()).orElseThrow(()->new EntityNotFoundException("Usuário não existe"));
        this.pacienteRepository.findById(medicamentoDTO.getPaciente().getId()).orElseThrow(()->new EntityNotFoundException("Paciente não existe"));
        BeanUtils.copyProperties(medicamentoDTO,medicamento);
        medicamento.setAdministracao(LocalDateTime.now());
        medicamento = this.repository.save(medicamento);
        BeanUtils.copyProperties(medicamento,response);
        response.setIdentificador_paciente(medicamento.getPaciente().getId());
        response.setIdentificador_usuario(medicamento.getUsuario().getId());
        return response;
    }

    public AdministracaoMedicamentoResponseDTO atualizarAdimistracaoMedicamento(Long identificador, AdministracaoMedicamentoAtualizacaoDto medicamentoAtualizado) throws Exception {
        MedicamentoEntity medicamentoDb = this.repository.findById(identificador).orElseThrow(()->new EntityNotFoundException("administração de medicamento não encontrado"));
        AdministracaoMedicamentoResponseDTO response = new AdministracaoMedicamentoResponseDTO();
        if(medicamentoAtualizado.getAdministracao() != null){
            throw new Exception("A data e hora não podem ser modificadas");
        }
        medicamentoAtualizado.setAdministracao(medicamentoDb.getAdministracao());
        BeanUtils.copyProperties(medicamentoAtualizado,medicamentoDb);

        this.repository.save(medicamentoDb);
        BeanUtils.copyProperties(medicamentoDb,response);
        response.setIdentificador_paciente(medicamentoDb.getPaciente().getId());
        response.setIdentificador_usuario(medicamentoDb.getUsuario().getId());
        return response;
    }

    public AdministracaoMedicamentoBuscaDTO buscarAdministracaoMedicamento(Long identificador) {
        MedicamentoEntity medicamentoDb = this.repository.findById(identificador).orElseThrow(()->new EntityNotFoundException("Administração de medicamento não encontrado"));
        AdministracaoMedicamentoBuscaDTO medicamentoBuscaDTO = new AdministracaoMedicamentoBuscaDTO();
        PacienteResponseDto pacienteDto = new PacienteResponseDto();
        UsuarioResponseDTO usuarioDto = new UsuarioResponseDTO();
        EnderecoResponseDto enderecoDto = new EnderecoResponseDto();
        BeanUtils.copyProperties(medicamentoDb,medicamentoBuscaDTO);
        BeanUtils.copyProperties(medicamentoDb.getPaciente(),pacienteDto);
        BeanUtils.copyProperties(medicamentoDb.getUsuario(),usuarioDto);
        BeanUtils.copyProperties(medicamentoDb.getPaciente().getEndereco(),enderecoDto);
        medicamentoBuscaDTO.setPaciente(pacienteDto);
        medicamentoBuscaDTO.setUsuario(usuarioDto);
        medicamentoBuscaDTO.getPaciente().setEndereco(enderecoDto);
        return medicamentoBuscaDTO;
    }

    public void deletarAdministracaoMedicamento(Long identificador) {
        this.repository.findById(identificador).orElseThrow(EntityNotFoundException::new);
        this.repository.deleteById(identificador);
    }

    public List<EstatisticaDTO> estatisticas(){
        return this.repository.estatisticas();
    }
}
