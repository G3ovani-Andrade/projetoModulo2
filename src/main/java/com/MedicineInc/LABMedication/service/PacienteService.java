package com.MedicineInc.LABMedication.service;

import com.MedicineInc.LABMedication.dto.EnderecoResponseDto;
import com.MedicineInc.LABMedication.dto.PacienteCadastroDto;
import com.MedicineInc.LABMedication.dto.PacienteResponseDto;
import com.MedicineInc.LABMedication.entity.EnderecoEntity;
import com.MedicineInc.LABMedication.entity.MedicamentoEntity;
import com.MedicineInc.LABMedication.entity.PacienteEntity;
import com.MedicineInc.LABMedication.repository.EnderecoRepository;
import com.MedicineInc.LABMedication.repository.MedicamentoRepository;
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
    private MedicamentoRepository repositoryMedicamento;

    public PacienteResponseDto cadastrarPaciente(PacienteCadastroDto novoPaciente) {
        PacienteEntity paciente = new PacienteEntity();//cria um novo Paciente
        PacienteResponseDto response = new PacienteResponseDto();//cria uma resposta do tipo PacienteResponseDto
        EnderecoResponseDto enderecoDTO = new EnderecoResponseDto();//Cria um endereco Dto para response
        EnderecoEntity endereco = new EnderecoEntity();//cria um endereco para entidade
        BeanUtils.copyProperties(novoPaciente, paciente);//copia os dados do novo paciente para o pacienteEntity
        paciente.setEndereco(endereco);
        paciente.getEndereco().setId(novoPaciente.getEndereco().getId());
        paciente = this.repository.save(paciente);//salva o paciente entity
        BeanUtils.copyProperties(paciente, response);//copias os dados de retorno do banco para o response
        endereco = this.repositoryEndereco.findById(paciente.getEndereco().getId()).orElseThrow(EntityNotFoundException::new);
        BeanUtils.copyProperties(endereco, enderecoDTO);//transforma o endereco que veio do banco de dados para endereco Dto
        response.setEndereco(enderecoDTO);//adicona o endereco dto dentro do paciente dto
        return response;
    }

    public PacienteResponseDto atualizarPaciente(Long id, PacienteCadastroDto pacienteAtualizado) throws Exception {
        PacienteEntity pacienteBd = new PacienteEntity();
        EnderecoEntity enderecoBd = new EnderecoEntity();
        PacienteResponseDto responseDto = new PacienteResponseDto();
        EnderecoResponseDto enderecoDto = new EnderecoResponseDto();
        pacienteBd = this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        enderecoBd = this.repositoryEndereco.findById(pacienteAtualizado.getEndereco().getId()).orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado"));
        BeanUtils.copyProperties(pacienteAtualizado, pacienteBd);
        pacienteBd.setEndereco(enderecoBd);
        pacienteBd = this.repository.save(pacienteBd);
        BeanUtils.copyProperties(pacienteBd, responseDto);
        BeanUtils.copyProperties(pacienteBd.getEndereco(), enderecoDto);
        responseDto.setEndereco(enderecoDto);
        return responseDto;
    }

    public List<PacienteResponseDto> buscarPacientes(String nomePaciente) {
        List<PacienteResponseDto> pacientesDto = new ArrayList<>();
        List<PacienteEntity> pacientesDb;
        if (nomePaciente == null || nomePaciente.isEmpty()) {
            pacientesDb = this.repository.findAll();
        } else {
            pacientesDb = this.repository.findByNomeCompletoContains(nomePaciente);
        }

        for (PacienteEntity paciente : pacientesDb) {
            EnderecoResponseDto enderecoDto = new EnderecoResponseDto();
            PacienteResponseDto pacienteDto = new PacienteResponseDto();
            BeanUtils.copyProperties(paciente, pacienteDto);
            BeanUtils.copyProperties(paciente.getEndereco(), enderecoDto);
            pacienteDto.setEndereco(enderecoDto);
            pacientesDto.add(pacienteDto);
        }
        return pacientesDto;
    }

    public PacienteResponseDto buscarPacientePorId(Long identificador) {
        PacienteResponseDto pacienteDto = new PacienteResponseDto();
        EnderecoResponseDto enderecoDto = new EnderecoResponseDto();
        PacienteEntity pacienteDb = this.repository.findById(identificador).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        BeanUtils.copyProperties(pacienteDb, pacienteDto);
        BeanUtils.copyProperties(pacienteDb.getEndereco(), enderecoDto);
        pacienteDto.setEndereco(enderecoDto);
        return pacienteDto;
    }

    public void deletarPaciente(Long identificador) throws Exception {
        this.repository.findById(identificador).orElseThrow(()-> new EntityNotFoundException("Usuário não encontrado"));
        List<MedicamentoEntity> medicamentos = this.repositoryMedicamento.findByPacienteId(identificador);
        if(medicamentos.size()>0){
            throw new Exception("Usuários com medicamentos não podem ser excluídos");
        }
        this.repository.deleteById(identificador);
    }
}
