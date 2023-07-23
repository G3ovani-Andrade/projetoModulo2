package com.MedicineInc.LABMedication.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EspecializacaoClinicaEnum {
    GERAL("Clínico Geral"),
    ANESTESISTA("Anestesista"),
    DERMATOLOGIA("Dermatologia"),
    GINECOLOGIA("Ginecologia"),
    NEUROLOGIA("Neurologia"),
    PEDIATRIA("Pediatria"),
    PSIQUIATRIA("Psiquiatria"),
    ORTOPEDIA("Ortopedia");
    private final String descricao;

    EspecializacaoClinicaEnum(String descricao) {
           this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static EspecializacaoClinicaEnum fromString(String value){
        for(EspecializacaoClinicaEnum e: EspecializacaoClinicaEnum.values()){
            try {
                if(e.ordinal() == Integer.parseInt(value)){
                    return e;
                }
            }catch (NumberFormatException erro){
                throw new NumberFormatException("Especialização Clínica inválida\n" +
                        "0 - Clínico Geral\n" +
                        "1 - Anestesista\n" +
                        "2 - Dermatologia\n"+
                        "3 - Ginecologia\n"+
                        "4 - Neurologia\n"+
                        "5 - Pediatria\n"+
                        "6 - Psiquiatria\n"+
                        "7 - Ortopedia");
            }
        }
        throw new IllegalArgumentException("Especialização Clínica inválida\n" +
                "0 - Clínico Geral\n" +
                "1 - Anestesista\n" +
                "2 - Dermatologia\n"+
                "3 - Ginecologia\n"+
                "4 - Neurologia\n"+
                "5 - Pediatria\n"+
                "6 - Psiquiatria\n"+
                "7 - Ortopedia");
    }
}
