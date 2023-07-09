package com.MedicineInc.LABMedication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    private String especializacao;
    @Column(nullable = false)
    @Size(min = 8, message = "tamanho mínimo 8 caracteres")
    @Size(max = 15, message = "tamanho maximo 15 caracteres")
    private String senha;

}
