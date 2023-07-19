package com.MedicineInc.LABMedication.service;

import com.MedicineInc.LABMedication.dto.AdministracaoMedicamentoCadastroDTO;
import com.MedicineInc.LABMedication.dto.AdministracaoMedicamentoResponseDTO;
import com.MedicineInc.LABMedication.entity.MedicamentoEntity;
import com.MedicineInc.LABMedication.repository.MedicamentoRepository;
import com.MedicineInc.LABMedication.repository.PacienteRepository;
import com.MedicineInc.LABMedication.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
        AdministracaoMedicamentoResponseDTO reponse = new AdministracaoMedicamentoResponseDTO();
        this.usuarioRepository.findById(medicamentoDTO.getUsuario().getId()).orElseThrow(()->new EntityNotFoundException("Usuário não existe"));
        this.pacienteRepository.findById(medicamentoDTO.getPaciente().getId()).orElseThrow(()->new EntityNotFoundException("Paciente não existe"));
        BeanUtils.copyProperties(medicamentoDTO,medicamento);
        medicamento.setAdministracao(LocalDateTime.now());
        medicamento = this.repository.save(medicamento);
        BeanUtils.copyProperties(medicamento,reponse);
        reponse.setTipo(medicamento.getTipo().getDescricao());
        reponse.setUnidade(medicamento.getUnidade().getDescricao());
        reponse.setPacienteID(medicamento.getPaciente().getId());
        reponse.setUsuarioID(medicamento.getUsuario().getId());
        return reponse;
    }
}
