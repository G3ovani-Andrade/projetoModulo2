package com.MedicineInc.LABMedication.service;

import com.MedicineInc.LABMedication.dto.EnderecoResponseDto;
import com.MedicineInc.LABMedication.dto.PacienteCadastroDto;
import com.MedicineInc.LABMedication.dto.PacienteResponseDto;
import com.MedicineInc.LABMedication.entity.EnderecoEntity;
import com.MedicineInc.LABMedication.entity.PacienteEntity;
import com.MedicineInc.LABMedication.repository.EnderecoRepository;
import com.MedicineInc.LABMedication.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;
    @Autowired
    private EnderecoRepository repositoryEndereco;

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
        BeanUtils.copyProperties(endereco,enderecoDTO);//transforma o endereco que veio do banco de dados para endereco Dto
        response.setEndereco(enderecoDTO);//adicona o endereco dto dentro do paciente dto
        return response;
    }
}
