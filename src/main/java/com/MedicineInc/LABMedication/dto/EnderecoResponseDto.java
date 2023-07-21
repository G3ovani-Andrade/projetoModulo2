package com.MedicineInc.LABMedication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponseDto {

    private Long id;

    @NotBlank(message = "Cep Obrigatório")
    private String cep;

    @NotBlank(message = "Cidade Obrigatório")
    private String cidade;

    @NotBlank(message = "Estado Obrigatório")
    private String estado;

    @NotBlank(message = "Logradouro Obrigatório")
    private String logradouro;

    @NotNull(message = "Número Obrigatório")
    private int numero;

    private String complemento;

    @NotBlank(message = "Bairro Obrigatório")
    private String bairro;

    private String referencia;
}
