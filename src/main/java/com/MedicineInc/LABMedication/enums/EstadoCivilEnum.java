package com.MedicineInc.LABMedication.enums;

public enum EstadoCivilEnum {
    SOLTEIRO(1,"Solteiro"),
    CASADO(2,"Casado"),
    SEPARADO(3,"Separado"),
    DIVORCIADO(4,"Divorciado"),
    VIUVO(5,"Viúvo");
    private int valor;
    private String descricao;

    EstadoCivilEnum(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }
}
