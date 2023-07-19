package com.MedicineInc.LABMedication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdministracaoMedicamentoResponseDTO {

    private Long id;

    @NotBlank(message = "Nome do medicamento obrigatório")
    private String nomeMedicamento;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @NotNull(message = "Data inválida")
    private LocalDateTime administracao;

    private String tipo;

    @NotBlank(message = "Quantidade obrigatório")
    private int quantidade;

    private String unidade;

    @NotBlank(message = "Observações obrigatório")
    private String observacoes;

    //mappeamento para medico
    @NotNull(message = "Usuário obrigatório")
    private Long usuarioID;
    // mappeamento para paciente
    @NotNull(message = "Paciente obrigatório")
    private Long pacienteID;
}
