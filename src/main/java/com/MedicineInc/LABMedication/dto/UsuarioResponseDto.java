package com.MedicineInc.LABMedication.dto;

import com.MedicineInc.LABMedication.enums.EspecializacaoClinicaEnum;
import com.MedicineInc.LABMedication.enums.EstadoCivilEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDto {

    private Long id;

    @NotBlank(message = "Nome Obrigatório")
    private String nomeCompleto;

    @NotBlank(message = "Gênero Obrigatório")
    private String genero;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Data invàlida")
    private LocalDate dataNascimento;

    @NotNull(message = "CPF obrigatório")
    @CPF(message = "Formato CPF inválido")
    private String cpf;

    @NotBlank(message = "Rg Obrigatório")
    private String rg;

    @NotNull(message = "Estado civil Obrigatório")
    private EstadoCivilEnum estadoCivil;

    @NotBlank(message = "Telefone Obrigatório")
    private String telefone;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email Obrigatório")
    private String email;

    @NotBlank(message = "Naturalidade Obrigatório")
    private String naturalidade;

    @NotBlank(message = "Crm Obrigatório")
    private String crmUf;

    @NotNull(message = "Especialização Obrigatório")
    private EspecializacaoClinicaEnum especializacao;

    @NotBlank(message = "Campo senha obrigatório")
    @Size(min = 8, message = "tamanho mínimo 8 caracteres")
    @Size(max = 15, message = "tamanho maximo 15 caracteres")
    private String senha;

    public String getEstadoCivil() {
        return estadoCivil.getDescricao();
    }

    public String getEspecializacao() {
        return especializacao.getDescricao();
    }
}
