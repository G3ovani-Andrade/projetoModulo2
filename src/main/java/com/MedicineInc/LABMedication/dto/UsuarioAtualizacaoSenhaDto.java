package com.MedicineInc.LABMedication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioAtualizacaoSenhaDto {

    @NotBlank(message = "Campo senha obrigatório")
    @Size(min = 8, message = "tamanho mínimo 8 caracteres")
    @Size(max = 15, message = "tamanho maximo 15 caracteres")
    private String senhaAntiga;

    @NotBlank(message = "Campo senha obrigatório")
    @Size(min = 8, message = "tamanho mínimo 8 caracteres")
    @Size(max = 15, message = "tamanho maximo 15 caracteres")
    private String senhaNova;
}
