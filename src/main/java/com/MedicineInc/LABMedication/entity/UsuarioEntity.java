package com.MedicineInc.LABMedication.entity;

import com.MedicineInc.LABMedication.enums.EspecializacaoClinicaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "usuario")
@Getter @Setter
@NoArgsConstructor
public class UsuarioEntity extends PessoaEntity{

    @Column(nullable = false)
    @NotBlank(message = "Crm Obrigatório")
    private String crmUf;

    @Column(nullable = false)
    @NotNull(message = "Especialização Obrigatório")
    private EspecializacaoClinicaEnum especializacao;

    @Column(nullable = false)
    @NotNull(message = "Campo senha obrigatório")
    @Size(min = 8, message = "tamanho mínimo 8 caracteres")
    @Size(max = 15, message = "tamanho maximo 15 caracteres")
    private String senha;

}
