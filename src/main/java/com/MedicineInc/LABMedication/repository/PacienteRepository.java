package com.MedicineInc.LABMedication.repository;

import com.MedicineInc.LABMedication.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity,Long> {
}
