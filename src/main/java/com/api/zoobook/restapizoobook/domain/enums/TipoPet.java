package com.api.zoobook.restapizoobook.domain.enums;

public enum TipoPet {

    CANINOS(1, "Caninos"),
    FELINOS(2, "Felinos"),
    EQUINOS(3, "Equinos"),
    AVES(4, "Aves"),
    PEIXES(5, "Peixes"),
    REPTEIS(6, "Repteis"),
    INSETOS(7, "Insetos"),
    OUTROS(8, "Outros");

    private int cod;
    private String descricao;

    TipoPet(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoPet toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for (TipoPet x : TipoPet.values()){

            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido" + cod);
    }
}
