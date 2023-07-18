package com.MedicineInc.LABMedication.repository;

import com.MedicineInc.LABMedication.entity.MedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity,Long> {

    List<MedicamentoEntity> findByPacienteId(Long identificador);
}
