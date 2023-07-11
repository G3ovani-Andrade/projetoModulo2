package com.MedicineInc.LABMedication.entity;

import com.MedicineInc.LABMedication.enums.EspecializacaoClinicaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter @Setter
@NoArgsConstructor
public class UsuarioEntity extends PessoaEntity{
    @Column(nullable = false)
    private String crmUf;

    @Column(nullable = false)
    private EspecializacaoClinicaEnum especializacao;

    @Size(min = 8, message = "tamanho mínimo 8 caracteres")
    @Size(max = 15, message = "tamanho maximo 15 caracteres")
    private String senha;

}
