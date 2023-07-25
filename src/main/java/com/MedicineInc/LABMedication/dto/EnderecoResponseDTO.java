package com.MedicineInc.LABMedication.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponseDTO {

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

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)

    public EnderecoResponseDTO(String id) {
        if(id == null){
            throw new IllegalArgumentException("Endereço deve ser informado");
        }
        try {
            this.id = Long.valueOf(id);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Id de endereço deve ser um número");
        }

    }
}
