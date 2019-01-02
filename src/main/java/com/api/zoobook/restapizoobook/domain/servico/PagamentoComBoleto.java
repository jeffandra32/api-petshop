package com.api.zoobook.restapizoobook.domain.servico;

import com.api.zoobook.restapizoobook.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@JsonTypeName("pagamentoComBoleto")
public class PagamentoComBoleto extends Pagamento {
    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dateVencement;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date datePayment;

    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Servico servico, Date dateVencement, Date datePayment) {
        super(id, estado, servico);
        this.datePayment = datePayment;
        this.dateVencement = dateVencement;
    }

    public Date getdateVencement() {
        return dateVencement;
    }

    public void setdateVencement(Date dateVencement) {
        this.dateVencement = dateVencement;
    }

    public Date getdatePayment() {
        return datePayment;
    }

    public void setdatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

}