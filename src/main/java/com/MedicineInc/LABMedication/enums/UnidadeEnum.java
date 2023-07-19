package com.MedicineInc.LABMedication.enums;

public enum UnidadeEnum {
    MG("mg"),
    MGC("mgc"),
    G("g"),
    ML("mL"),
    PORCENTAGEM("%");
    private String descricao;

    UnidadeEnum(String descricao) {

        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
