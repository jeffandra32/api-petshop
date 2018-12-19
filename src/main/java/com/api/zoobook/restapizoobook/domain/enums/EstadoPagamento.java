package com.api.zoobook.restapizoobook.domain.enums;



public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado"),
    CONCLUIDO(4, "Concluído");

    private int cod;
    private String descricao;

    EstadoPagamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    //Converter Enum para int//

    public static EstadoPagamento toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for (EstadoPagamento x : EstadoPagamento.values()){

            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido" + cod);
    }
}
