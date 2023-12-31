package com.MedicineInc.LABMedication.entity;

import com.MedicineInc.LABMedication.enums.TipoMedicamentoEnum;
import com.MedicineInc.LABMedication.enums.UnidadeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="administracaoDeMedicamentos")
@Getter @Setter
public class AdministracaoDeMedicamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nomeMedicamento;
    @Column(nullable = false)
    private LocalDateTime administracao;
    private TipoMedicamentoEnum tipo;
    @Column(nullable = false)
    private int quantidade;
    private UnidadeEnum unidade;
    @Column(nullable = false)
    private String observacoes;

    //mappeamento para medico

    @ManyToOne
    @JoinColumn(name = "usuario_id",nullable = false)
    private UsuarioEntity usuario;

    // mappeamento para paciente

    @ManyToOne
    @JoinColumn(name = "paciente_id",nullable = false)
    private PacienteEntity paciente;

}
