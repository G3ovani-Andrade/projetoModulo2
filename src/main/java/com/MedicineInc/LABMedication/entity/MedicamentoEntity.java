package com.MedicineInc.LABMedication.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="medicamento")
public class MedicamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nomeMedicamento;
    @Column(nullable = false)
    private Date administracao;

    private String tipo;
    @Column(nullable = false)
    private int quantidade;
    private String unidade;
    @Column(nullable = false)
    private String observacoes;

    //falta mappeamento pra medico
    //falta mappeamento pra paciente

}
