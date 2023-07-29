package com.MedicineInc.LABMedication.dto;

import com.MedicineInc.LABMedication.enums.TipoMedicamentoEnum;
import com.MedicineInc.LABMedication.enums.UnidadeEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdministracaoMedicamentoCadastroDTO {

    @NotBlank(message = "Nome do medicamento obrigatório")
    private String nomeMedicamento;

    @NotNull(message = "Tipo do mendicamento deve ser informado")
    private TipoMedicamentoEnum tipo;

    @Min(value = 1,message = "O valor minimo é 1")
    private int quantidade;

    @NotNull(message = "Unidade do mendicamento deve ser informado")
    private UnidadeEnum unidade;

    @NotBlank(message = "Observações obrigatório")
    private String observacoes;

    //mappeamento para medico
    @NotNull(message = "Usuário obrigatório")
    private UsuarioResponseDTO usuario;
    // mappeamento para paciente
    @NotNull(message = "Paciente obrigatório")
    private PacienteResponseDTO paciente;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public AdministracaoMedicamentoCadastroDTO(String quantidade) throws Exception {
        try {
            this.quantidade = Integer.parseInt(quantidade);
        }catch (NumberFormatException e){
           throw  new NumberFormatException("Valor mínimo para quantidade: 1");
        }
    }
}
