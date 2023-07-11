package com.MedicineInc.LABMedication.enums;

public enum TipoMedicamentoEnum {
    CAPSULA(1,"Cápsula"),
    COPRIMIDO(2,"Comprimido"),
    LIQUIDO(3,"Líquido"),
    CREME(4,"Creme"),
    GEL(5,"Gel"),
    INLACAO(6,"Inalação"),
    INJECAO(7,"Injeção"),
    SPRAY(8,"Injeção");
    private int valor;
    private String descricao;

    TipoMedicamentoEnum(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }
}
