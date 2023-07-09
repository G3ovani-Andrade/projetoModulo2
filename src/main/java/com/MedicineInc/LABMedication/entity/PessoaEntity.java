package com.MedicineInc.LABMedication.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String genero;
    @Column(nullable = false)
    private Date dataNascimento;
    @Column(unique = true)
    private String cpf;
    private String rg;
    @Column(nullable = false)
    private String estadoCivil;
    private String telefone;
    @Email(message = "Não é um email válido")
    @NotBlank(message = "Email nao pode estar Vazio")
    private String email;
    private String naturalidade;

}
