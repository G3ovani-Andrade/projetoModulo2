package com.MedicineInc.LABMedication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioAtualizacaoSenhaDTO {

    @NotBlank(message = "Senha atual obrigatório")
    @Size(min = 8, message = "tamanho mínimo 8 caracteres")
    private String senhaAntiga;

    @NotBlank(message = "Senha nova obrigatório")
    @Size(min = 8, message = "tamanho mínimo 8 caracteres")
    private String senhaNova;
}
