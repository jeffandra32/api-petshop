package com.api.zoobook.restapizoobook.domain.servico;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="servico_id")
    private Servico servico;

    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    public Servico getServico() {
        return servico;
    }
    public void setServico(Servico servico) {
        this.servico = servico;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((servico == null) ? 0 : servico.hashCode());
        result = prime * result + ((produto == null) ? 0 : produto.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemPedidoPK other = (ItemPedidoPK) obj;
        if (servico == null) {
            if (other.servico != null)
                return false;
        } else if (!servico.equals(other.servico))
            return false;
        if (produto == null) {
            if (other.produto != null)
                return false;
        } else if (!produto.equals(other.produto))
            return false;
        return true;
    }



}