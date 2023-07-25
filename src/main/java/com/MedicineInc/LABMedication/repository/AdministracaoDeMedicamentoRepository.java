package com.MedicineInc.LABMedication.repository;

import com.MedicineInc.LABMedication.dto.EstatisticaDTO;
import com.MedicineInc.LABMedication.entity.AdministracaoDeMedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministracaoDeMedicamentoRepository extends JpaRepository<AdministracaoDeMedicamentoEntity,Long> {

    List<AdministracaoDeMedicamentoEntity> findByPacienteId(Long identificador);

    @Query(value = "SELECT P.NOME_COMPLETO as nome_completo,COUNT(*)as total_medicamentos FROM ADMINISTRACAO_DE_MEDICAMENTOS M JOIN PACIENTE P ON P.ID = M.PACIENTE_ID GROUP BY P.ID",nativeQuery = true)
    List<EstatisticaDTO> estatisticas();
}
