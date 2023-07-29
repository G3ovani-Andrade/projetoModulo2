package com.MedicineInc.LABMedication.entity;

import com.MedicineInc.LABMedication.enums.EspecializacaoClinicaEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity extends PessoaEntity {

    @Column(nullable = false)
    private String crmUf;

    @Column(nullable = false)
    private EspecializacaoClinicaEnum especializacao;

    @Column(nullable = false)
    private String senha;

}
