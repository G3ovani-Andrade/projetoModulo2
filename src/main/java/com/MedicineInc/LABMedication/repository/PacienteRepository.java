package com.MedicineInc.LABMedication.repository;

import com.MedicineInc.LABMedication.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity,Long> {
    @Query(value = "SELECT * FROM PACIENTE WHERE NOME_COMPLETO ILIKE :nomePaciente%",nativeQuery = true)
    List<PacienteEntity> findByNomeCompleto(String nomePaciente);
}
