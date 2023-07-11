package com.MedicineInc.LABMedication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @OneToOne
    @JoinColumn(name = "endereco_id",referencedColumnName = "id")
    private EnderecoEntity endereco;

}
