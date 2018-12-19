package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.Vacina;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


public class VacinaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    private String tipo;

    @NotEmpty(message="Preenchimento obrigatório")
    private String prioridade;

    @NotEmpty(message="Preenchimento obrigatório")
    private Double qtd_dose;

    public VacinaDTO() {
    }

    public VacinaDTO(Vacina obj) {
        id = obj.getId();
        tipo = obj.getTipo();
        prioridade = obj.getPrioridade();
        qtd_dose = obj.getQtd_dose();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Double getQtd_dose() {
        return qtd_dose;
    }

    public void setQtd_dose(Double qtd_dose) {
        this.qtd_dose = qtd_dose;
    }
}
