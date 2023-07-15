package com.MedicineInc.LABMedication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "paciente")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteEntity extends PessoaEntity{
    @Column(nullable = false)
    private String contatoEmergencia;

    private String alergias;

    private String cuidadosEspecificos;

    private String convenio;

    private String numeroCarteira;


    private LocalDate validadeCarteira;

    //fazer mappeamento para endereco
    @OneToOne
    @JoinColumn(name = "endereco_id",referencedColumnName = "id",nullable = false)
    private EnderecoEntity endereco;
    
}
