package com.MedicineInc.LABMedication.service;

import com.MedicineInc.LABMedication.dto.EnderecoResponseDTO;
import com.MedicineInc.LABMedication.dto.PacienteCadastroDTO;
import com.MedicineInc.LABMedication.dto.PacienteResponseDTO;
import com.MedicineInc.LABMedication.entity.EnderecoEntity;
import com.MedicineInc.LABMedication.entity.AdministracaoDeMedicamentoEntity;
import com.MedicineInc.LABMedication.entity.PacienteEntity;
import com.MedicineInc.LABMedication.repository.EnderecoRepository;
import com.MedicineInc.LABMedication.repository.AdministracaoDeMedicamentoRepository;
import com.MedicineInc.LABMedication.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;
    @Autowired
    private EnderecoRepository repositoryEndereco;
    @Autowired
    private AdministracaoDeMedicamentoRepository repositoryMedicamento;

    public PacienteResponseDTO cadastrarPaciente(PacienteCadastroDTO novoPaciente) {
        EnderecoEntity endereco = this.repositoryEndereco.findById(novoPaciente.getEndereco().getId()).orElseThrow(()->new EntityNotFoundException("Endereço não encontrado"));
        PacienteEntity paciente = new PacienteEntity();
        PacienteResponseDTO response = new PacienteResponseDTO();
        EnderecoResponseDTO enderecoDTO = new EnderecoResponseDTO();
        BeanUtils.copyProperties(novoPaciente, paciente);
        paciente.setEndereco(endereco);
        paciente.getEndereco().setId(novoPaciente.getEndereco().getId());
        paciente = this.repository.save(paciente);
        BeanUtils.copyProperties(paciente, response);
        BeanUtils.copyProperties(endereco, enderecoDTO);
        response.setEndereco(enderecoDTO);
        return response;
    }

    public PacienteResponseDTO atualizarPaciente(Long id, PacienteCadastroDTO pacienteAtualizado){
        PacienteEntity pacienteBd = this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
        EnderecoEntity enderecoBd = this.repositoryEndereco.findById(pacienteAtualizado.getEndereco().getId()).orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado"));
        PacienteResponseDTO responseDto = new PacienteResponseDTO();
        EnderecoResponseDTO enderecoDto = new EnderecoResponseDTO();
        BeanUtils.copyProperties(pacienteAtualizado, pacienteBd);
        pacienteBd.setEndereco(enderecoBd);
        pacienteBd = this.repository.save(pacienteBd);
        BeanUtils.copyProperties(pacienteBd, responseDto);
        BeanUtils.copyProperties(pacienteBd.getEndereco(), enderecoDto);
        responseDto.setEndereco(enderecoDto);
        return responseDto;
    }

    public List<PacienteResponseDTO> buscarPacientes(String nomePaciente) {
        List<PacienteResponseDTO> pacientesDto = new ArrayList<>();
        List<PacienteEntity> pacientesDb;
        if (nomePaciente == null || nomePaciente.isEmpty()) {
            pacientesDb = this.repository.findAll();
        } else {
            pacientesDb = this.repository.findByNomeCompleto(nomePaciente);
        }

        for (PacienteEntity paciente : pacientesDb) {
            EnderecoResponseDTO enderecoDto = new EnderecoResponseDTO();
            PacienteResponseDTO pacienteDto = new PacienteResponseDTO();
            BeanUtils.copyProperties(paciente, pacienteDto);
            BeanUtils.copyProperties(paciente.getEndereco(), enderecoDto);
            pacienteDto.setEndereco(enderecoDto);
            pacientesDto.add(pacienteDto);
        }
        return pacientesDto;
    }

    public PacienteResponseDTO buscarPacientePorId(Long identificador) {
        PacienteResponseDTO pacienteDto = new PacienteResponseDTO();
        EnderecoResponseDTO enderecoDto = new EnderecoResponseDTO();
        PacienteEntity pacienteDb = this.repository.findById(identificador).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
        BeanUtils.copyProperties(pacienteDb, pacienteDto);
        BeanUtils.copyProperties(pacienteDb.getEndereco(), enderecoDto);
        pacienteDto.setEndereco(enderecoDto);
        return pacienteDto;
    }

    public void deletarPaciente(Long identificador){
        this.repository.findById(identificador).orElseThrow(()-> new EntityNotFoundException("Paciente não encontrado"));
        List<AdministracaoDeMedicamentoEntity> medicamentos = this.repositoryMedicamento.findByPacienteId(identificador);
        if(medicamentos.size()>0){
            throw new IllegalArgumentException("Paciente com medicamentos não podem ser excluídos");
        }
        this.repository.deleteById(identificador);
    }
}
