package com.MedicineInc.LABMedication.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum UnidadeEnum {
    MG("mg"),
    MGC("mgc"),
    G("g"),
    ML("mL"),
    PORCENTAGEM("%");
    private final String descricao;

    UnidadeEnum(String descricao) {

        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static UnidadeEnum fromString(String value) {
        for (UnidadeEnum e:UnidadeEnum.values()){
            try {
                if (e.ordinal() == Integer.parseInt(value)) {
                    return e;
                }
            }catch (NumberFormatException erro){
                throw new NumberFormatException("Unidade inválida\n" +
                        "0 - mg\n" +
                        "1 - mcg\n" +
                        "2 - g\n" +
                        "3 - mL\n" +
                        "4 -  %\n");
            }
        }
        throw new IllegalArgumentException("Unidade inválida\n" +
                "0 - mg\n" +
                "1 - mcg\n" +
                "2 - g\n" +
                "3 - mL\n" +
                "4 -  %\n");

    }
}
