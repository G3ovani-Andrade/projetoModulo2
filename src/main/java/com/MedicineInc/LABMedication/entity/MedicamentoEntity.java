package com.MedicineInc.LABMedication.entity;

import com.MedicineInc.LABMedication.enums.TipoMedicamentoEnum;
import com.MedicineInc.LABMedication.enums.UnidadeEnum;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

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
    private TipoMedicamentoEnum tipo;
    @Column(nullable = false)
    private int quantidade;
    private UnidadeEnum unidade;
    @Column(nullable = false)
    private String observacoes;

    //mappeamento para medico

    @OneToOne
    @JoinColumn(name = "usuario_id",nullable = false)
    private UsuarioEntity usuario;

    // mappeamento para paciente

    @OneToOne
    @JoinColumn(name = "paciente_id",nullable = false)
    private PacienteEntity paciente;

}
