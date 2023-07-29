package com.MedicineInc.LABMedication.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Número Obrigatório")
    private int numero;

    private String complemento;

    @NotBlank(message = "Bairro Obrigatório")
    private String bairro;

    private String referencia;
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public EnderecoCadastroDTO(String numero) {
        try {
            this.numero = Integer.parseInt(numero);
        }catch (NumberFormatException e){
            throw  new NumberFormatException("Valor mínimo para número: 1");
        }
    }
}
