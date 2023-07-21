package com.MedicineInc.LABMedication.service;

import com.MedicineInc.LABMedication.dto.EnderecoCadastroDTO;
import com.MedicineInc.LABMedication.dto.EnderecoResponseDto;
import com.MedicineInc.LABMedication.entity.EnderecoEntity;
import com.MedicineInc.LABMedication.repository.EnderecoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;
    public EnderecoResponseDto cadastrarEndereco(EnderecoCadastroDTO enderecoNovo) {
        EnderecoEntity endereco = new EnderecoEntity();
        EnderecoResponseDto response = new EnderecoResponseDto();
        BeanUtils.copyProperties(enderecoNovo,endereco);
        endereco = this.repository.save(endereco);
        BeanUtils.copyProperties(endereco,response);
        return response;
    }
    public List<EnderecoResponseDto> listarEnderecos() {
        List<EnderecoResponseDto>enderecosDto = new ArrayList<>();
        List<EnderecoEntity> enderecosDb = this.repository.findAll();
        for(EnderecoEntity endereco : enderecosDb){
            EnderecoResponseDto enderecoDto = new EnderecoResponseDto();
            BeanUtils.copyProperties(endereco,enderecoDto);
            enderecosDto.add(enderecoDto);
        }
        return enderecosDto;
    }
}
