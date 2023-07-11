package com.MedicineInc.LABMedication.enums;

import lombok.ToString;

public enum EstadoCivilEnum {
    SOLTEIRO(1,"Solteiro"),
    CASADO(2,"Casado"),
    SEPARADO(3,"Separado"),
    DIVORCIADO(4,"Divorciado"),
    VIUVO(5,"Viúvo");
    private final int valor;
    private final String descricao;

     EstadoCivilEnum(int valor, String descricao){
        this.valor = valor;
        this.descricao = descricao;
    }
}
