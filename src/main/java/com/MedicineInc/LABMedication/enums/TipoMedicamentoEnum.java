package com.MedicineInc.LABMedication.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoMedicamentoEnum {
    CAPSULA("Cápsula"),
    COPRIMIDO("Comprimido"),
    LIQUIDO("Líquido"),
    CREME("Creme"),
    GEL("Gel"),
    INLACAO("Inalação"),
    INJECAO("Injeção"),
    SPRAY("Spray");

    private final String descricao;

    TipoMedicamentoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static TipoMedicamentoEnum fromString(String value){
        for (TipoMedicamentoEnum e : TipoMedicamentoEnum.values()){
            try {
                if(e.ordinal()==Integer.parseInt(value)){
                    return e;
                }
            }catch (NumberFormatException erro){
                throw new NumberFormatException("Tipo inválido\n" +
                        "0 - Cápsula\n"+
                        "1 - Comprimido\n"+
                        "2 - Líquido\n"+
                        "3 - Creme\n"+
                        "4 - Gel\n"+
                        "5 - Inalação\n"+
                        "6 - Injeção\n"+
                        "7 - Spray\n");
            }

        }
        throw new IllegalArgumentException("Tipo inválido\n" +
                "0 - Cápsula\n"+
                "1 - Comprimido\n"+
                "2 - Líquido\n"+
                "3 - Creme\n"+
                "4 - Gel\n"+
                "5 - Inalação\n"+
                "6 - Injeção\n"+
                "7 - Spray\n");
    }

}
