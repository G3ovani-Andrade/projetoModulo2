package com.MedicineInc.LABMedication.dto;

import com.MedicineInc.LABMedication.enums.EstadoCivilEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteCadastroDTO {

    @NotBlank(message = "Nome Obrigatório")
    private String nomeCompleto;

    @NotBlank(message = "Gênero Obrigatório")
    private String genero;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Data de Nascimento em formato inválido, use formato dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull(message = "CPF obrigatório")
    @CPF(message = "Formato CPF inválido")
    private String cpf;

    @NotBlank(message = "Rg Obrigatório")
    private String rg;

    @NotNull(message = "Estado civil Obrigatório")
    private EstadoCivilEnum estadoCivil;

    @NotBlank(message = "Telefone Obrigatório")
    private String telefone;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email Obrigatório")
    private String email;

    @NotBlank(message = "Naturalidade Obrigatório")
    private String naturalidade;

    @NotBlank(message = "Contato de emergência Obrigatório")
    private String contatoEmergencia;

    private String alergias;

    private String cuidadosEspecificos;

    private String convenio;

    private String numeroCarteira;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate validadeCarteira;

    @NotNull(message = "Endereço deve ser informado")
    private EnderecoResponseDTO endereco;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PacienteCadastroDTO(String dataNascimento, String validadeCarteira) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            this.dataNascimento = LocalDate.from(formatter.parse(dataNascimento));
        }catch (Exception e){
           new Exception();
        }
        if(validadeCarteira != null && !(validadeCarteira.isBlank())){
            try {
                this.validadeCarteira = LocalDate.from(formatter.parse(validadeCarteira));
            }catch (Exception e){
                throw new IllegalArgumentException("Validade da carteira em formato inválido, use formato dd/MM/yyyy");
            }
        }
    }
}
