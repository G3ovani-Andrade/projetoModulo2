package com.MedicineInc.LABMedication.enums;

public enum TipoMedicamentoEnum {
    CAPSULA("Cápsula"),
    COPRIMIDO("Comprimido"),
    LIQUIDO("Líquido"),
    CREME("Creme"),
    GEL("Gel"),
    INLACAO("Inalação"),
    INJECAO("Injeção"),
    SPRAY("Spray");

    private String descricao;

    TipoMedicamentoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
