package com.MedicineInc.LABMedication.dto;

import com.MedicineInc.LABMedication.enums.TipoMedicamentoEnum;
import com.MedicineInc.LABMedication.enums.UnidadeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdministracaoMedicamentoBuscaDTO {
    private Long id;

    private String nomeMedicamento;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime administracao;

    private TipoMedicamentoEnum tipo;

    private int quantidade;

    private UnidadeEnum unidade;

    private String observacoes;

    //mappeamento para medico

    private UsuarioResponseDto usuario;
    // mappeamento para paciente

    private PacienteResponseDto paciente;

    public String getTipo() {
        return tipo.getDescricao();
    }

    public String getUnidade() {
        return unidade.getDescricao();
    }
}
