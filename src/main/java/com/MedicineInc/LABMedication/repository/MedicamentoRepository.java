package com.MedicineInc.LABMedication.repository;

import com.MedicineInc.LABMedication.entity.MedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity,Long> {

    List<MedicamentoEntity> findByPacienteId(Long identificador);
}
