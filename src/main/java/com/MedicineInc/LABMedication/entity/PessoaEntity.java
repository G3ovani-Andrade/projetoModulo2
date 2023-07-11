package com.MedicineInc.LABMedication.entity;


import com.MedicineInc.LABMedication.enums.EstadoCivilEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCompleto;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private Date dataNascimento;

    @Column(unique = true,nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String rg;

    @Column(nullable = false)
    private EstadoCivilEnum estadoCivil;

    @Column(nullable = false)
    private String telefone;

    @Email(message = "Não é um email válido")
    @NotBlank(message = "Email não pode estar Vazio")
    private String email;

    @Column(nullable = false)
    private String naturalidade;

}
