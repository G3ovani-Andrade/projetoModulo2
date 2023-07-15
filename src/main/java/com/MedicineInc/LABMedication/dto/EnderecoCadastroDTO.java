package com.MedicineInc.LABMedication.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class EnderecoCadastroDTO {

    @NotBlank(message = "Cep Obrigatório")
    private String cep;

    @NotBlank(message = "Cidade Obrigatório")
    private String cidade;

    @NotBlank(message = "Estado Obrigatório")
    private String estado;

    @NotBlank(message = "Logradouro Obrigatório")
    private String logradouro;

    @NotBlank(message = "Número Obrigatório")
    private int numero;

    private String complemento;

    @NotBlank(message = "Bairro Obrigatório")
    private String bairro;

    private String referencia;
}
