package com.MedicineInc.LABMedication.enums;

public enum UnidadeEnum {
    MG(1,"mg"),
    MGC(2,"mgc"),
    G(3,"g"),
    ML(4,"mL"),
    PORCENTAGEM(5,"%");
    private int valor;
    private String descricao;

    UnidadeEnum(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }
}
