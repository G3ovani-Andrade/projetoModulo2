package com.MedicineInc.LABMedication.service;

import com.MedicineInc.LABMedication.dto.*;
import com.MedicineInc.LABMedication.entity.AdministracaoDeMedicamentoEntity;
import com.MedicineInc.LABMedication.entity.PacienteEntity;
import com.MedicineInc.LABMedication.entity.UsuarioEntity;
import com.MedicineInc.LABMedication.repository.AdministracaoDeMedicamentoRepository;
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
    private AdministracaoDeMedicamentoRepository repository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    public AdministracaoMedicamentoResponseDTO cadastrarAdministracaoMedicamento(AdministracaoMedicamentoCadastroDTO medicamentoDTO) {
        AdministracaoDeMedicamentoEntity medicamento = new AdministracaoDeMedicamentoEntity();
        AdministracaoMedicamentoResponseDTO response = new AdministracaoMedicamentoResponseDTO();
        PacienteEntity paciente = new PacienteEntity();
        UsuarioEntity usuario = new UsuarioEntity();
        this.usuarioRepository.findById(medicamentoDTO.getUsuario().getId()).orElseThrow(()->new EntityNotFoundException("Usuário não existe"));
        this.pacienteRepository.findById(medicamentoDTO.getPaciente().getId()).orElseThrow(()->new EntityNotFoundException("Paciente não existe"));
        BeanUtils.copyProperties(medicamentoDTO,medicamento);
        BeanUtils.copyProperties(medicamentoDTO.getPaciente(),paciente);
        BeanUtils.copyProperties(medicamentoDTO.getUsuario(),usuario);
        medicamento.setPaciente(paciente);
        medicamento.setUsuario(usuario);
        medicamento.setAdministracao(LocalDateTime.now());
        medicamento = this.repository.save(medicamento);
        BeanUtils.copyProperties(medicamento,response);
        response.setIdentificador_paciente(medicamento.getPaciente().getId());
        response.setIdentificador_usuario(medicamento.getUsuario().getId());
        return response;
    }

    public AdministracaoMedicamentoResponseDTO atualizarAdimistracaoMedicamento(Long identificador, AdministracaoMedicamentoAtualizacaoDTO medicamentoAtualizado){
        AdministracaoDeMedicamentoEntity medicamentoDb = this.repository.findById(identificador).orElseThrow(()->new EntityNotFoundException("administração de medicamento não encontrada"));
        AdministracaoMedicamentoResponseDTO response = new AdministracaoMedicamentoResponseDTO();
        if(medicamentoAtualizado.getAdministracao() != null){
            throw new IllegalArgumentException("A data e hora não podem ser modificadas");
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
        AdministracaoDeMedicamentoEntity medicamentoDb = this.repository.findById(identificador).orElseThrow(()->new EntityNotFoundException("Administração de medicamento não encontrada"));
        AdministracaoMedicamentoBuscaDTO medicamentoBuscaDTO = new AdministracaoMedicamentoBuscaDTO();
        PacienteResponseDTO pacienteDto = new PacienteResponseDTO();
        UsuarioResponseDTO usuarioDto = new UsuarioResponseDTO();
        EnderecoResponseDTO enderecoDto = new EnderecoResponseDTO();
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
        this.repository.findById(identificador).orElseThrow(()->new EntityNotFoundException("Administração de medicamento não encontrada"));
        this.repository.deleteById(identificador);
    }

    public List<EstatisticaDTO> estatisticas(){
        return this.repository.estatisticas();
    }
}
