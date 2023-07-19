package com.MedicineInc.LABMedication.dto;

import com.MedicineInc.LABMedication.entity.PacienteEntity;
import com.MedicineInc.LABMedication.entity.UsuarioEntity;
import com.MedicineInc.LABMedication.enums.TipoMedicamentoEnum;
import com.MedicineInc.LABMedication.enums.UnidadeEnum;
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

    private TipoMedicamentoEnum tipo;

    @Min(value = 1,message = "O valor minimo é 1")
    private int quantidade;


    private UnidadeEnum unidade;

    @NotBlank(message = "Observações obrigatório")
    private String observacoes;

    //mappeamento para medico
    @NotNull(message = "Usuário obrigatório")
    private UsuarioEntity usuario;
    // mappeamento para paciente
    @NotNull(message = "Paciente obrigatório")
    private PacienteEntity paciente;

}
