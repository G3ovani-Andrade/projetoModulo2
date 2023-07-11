package com.MedicineInc.LABMedication.enums;

public enum EspecializacaoClinicaEnum {
    GERAL(1,"Geral"),
    ANESTESISTA(2,"Anestesista"),
    DERMATOLOGIA(3,"Dermatologia"),
    GINECOLOGIA(4,"Ginecologia"),
    NEUROLOGIA(5,"Neurologia"),
    PEDIATRIA(6,"Pediatria"),
    PSIQUIATRIA(7,"Psiquiatria"),
    ORTOPEDIA(8,"Ortopedia");
    private String descricao;
    private int Valor;

    EspecializacaoClinicaEnum(int valor,String descricao) {
        this.descricao = descricao;
        Valor = valor;
    }
}
