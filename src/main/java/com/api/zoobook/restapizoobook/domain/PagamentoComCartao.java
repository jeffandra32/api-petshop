package com.api.zoobook.restapizoobook.domain;

import com.api.zoobook.restapizoobook.enums.EstadoPagamento;

import javax.validation.constraints.NotEmpty;

public class PagamentoComCartao extends Pagamento{

    @NotEmpty(message = "Este campo não pode ser vazio")
    private Integer numeroDeParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
