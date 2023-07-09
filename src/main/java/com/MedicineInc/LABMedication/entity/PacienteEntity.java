package com.MedicineInc.LABMedication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paciente")
@Getter
@Setter
public class PacienteEntity extends PessoaEntity{
    @Column(nullable = false)
    private String contatoEmergencia;
    private String Alergias;
    private String CuidadosEspecificos;
    private String convenio;
    private String numeroCarteira;
    private String validadeCarteira;
    //fazer mappeamento para endereco
    //fazer mappeamento para medicamento
}
