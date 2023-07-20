package com.MedicineInc.LABMedication.repository;

import com.MedicineInc.LABMedication.dto.EstatisticaDTO;
import com.MedicineInc.LABMedication.entity.MedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity,Long> {

    List<MedicamentoEntity> findByPacienteId(Long identificador);

    @Query(value = "SELECT P.NOME_COMPLETO as nome_completo,COUNT(*)as total_medicamentos FROM MEDICAMENTO M JOIN PACIENTE P ON P.ID = M.PACIENTE_ID GROUP BY P.ID",nativeQuery = true)
    List<EstatisticaDTO> estatisticas();
}
