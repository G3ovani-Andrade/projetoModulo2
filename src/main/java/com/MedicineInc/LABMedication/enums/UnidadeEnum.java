package com.MedicineInc.LABMedication.enums;

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

}
