package com.MedicineInc.LABMedication.dto;

import com.MedicineInc.LABMedication.enums.TipoMedicamentoEnum;
import com.MedicineInc.LABMedication.enums.UnidadeEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdministracaoMedicamentoAtualizacaoDTO {

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime administracao;

    @NotNull(message = "Tipo do mendicamento deve ser informado")
    private TipoMedicamentoEnum tipo;

    @Min(value = 1,message = "O valor minimo é 1")
    private int quantidade;

    @NotNull(message = "Unidade do mendicamento deve ser informado")
    private UnidadeEnum unidade;

    @NotBlank(message = "Observações obrigatório")
    private String observacoes;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public AdministracaoMedicamentoAtualizacaoDTO(String administracao,String quantidade) throws Exception {
        try {
            this.quantidade = Integer.parseInt(quantidade);
        }catch (NumberFormatException e){
            throw  new NumberFormatException("Valor mínimo para quantidade: 1");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        if(administracao != null && !(administracao.isBlank())){
            try {
                this.administracao = LocalDateTime.from(formatter.parse(administracao));
            }catch (Exception e){
                throw new IllegalArgumentException("Data de administração de medicamento em formato inválido, use formato dd/MM/yyyy HH:mm:ss");
            }
        }

    }
}
