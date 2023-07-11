package com.MedicineInc.LABMedication.entity;


import com.MedicineInc.LABMedication.enums.EstadoCivilEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Getter @Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Nome Obrigatório")
    private String nomeCompleto;

    @Column(nullable = false)
    @NotBlank(message = "Gênero Obrigatório")
    private String genero;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    private Date dataNascimento;

    @Column(unique = true,nullable = false)
    @NotNull(message = "CPF obrigatório")
    @CPF(message = "Formato CPF inválido")
    private String cpf;

    @Column(nullable = false)
    @NotBlank(message = "Rg Obrigatório")
    private String rg;

    @Column(nullable = false)
    @NotNull(message = "Estado civil Obrigatório")
    private EstadoCivilEnum estadoCivil;

    @Column(nullable = false)
    @NotBlank(message = "Telefone Obrigatório")
    private String telefone;

    @Column(nullable = false)
    @Email(message = "Email inválido")
    @NotBlank(message = "Email Obrigatório")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Naturalidade Obrigatório")
    private String naturalidade;

}
