package com.MedicineInc.LABMedication.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EstadoCivilEnum {
    SOLTEIRO("Solteiro"),
    CASADO("Casado"),
    SEPARADO("Separado"),
    DIVORCIADO("Divorciado"),
    VIUVO("Viúvo");
    private final String descricao;

     EstadoCivilEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static EstadoCivilEnum fromString(String value){
        for(EstadoCivilEnum e: EstadoCivilEnum.values()){
            try {
                if(e.ordinal() == Integer.parseInt(value)){
                    return e;
                }
            }catch (NumberFormatException erro){
                throw new NumberFormatException("Estado Civil inválido\n" +
                        "0 - Solteiro\n" +
                        "1 - Casado\n" +
                        "2 - Separado\n"+
                        "3 - Divorciado\n"+
                        "4 - Viúvo");
            }
        }
        throw new IllegalArgumentException("Estado Civil inválido\n" +
                "0 - Solteiro\n" +
                "1 - Casado\n" +
                "2 - Separado\n"+
                "3 - Divorciado\n"+
                "4 - Viúvo");
    }
}
