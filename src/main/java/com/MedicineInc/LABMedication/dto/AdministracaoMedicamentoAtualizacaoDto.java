package com.MedicineInc.LABMedication.dto;

import com.MedicineInc.LABMedication.enums.TipoMedicamentoEnum;
import com.MedicineInc.LABMedication.enums.UnidadeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdministracaoMedicamentoAtualizacaoDto {

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime administracao;
    private TipoMedicamentoEnum tipo;
    @Min(value = 1,message = "O valor minimo é 1")
    private int quantidade;
    private UnidadeEnum unidade;
    @NotBlank(message = "Observações obrigatório")
    private String observacoes;
}
