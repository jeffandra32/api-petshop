package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.pet.Vacina;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


public class VacinaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    private String type;

    @NotEmpty(message="Preenchimento obrigatório")
    private String priority;

    @NotEmpty(message="Preenchimento obrigatório")
    private Double qtd_dose;

    public VacinaDTO() {
    }

    public VacinaDTO(Vacina obj) {
        id = obj.getId();
        type = obj.getType();
        priority = obj.getPriority();
        qtd_dose = obj.getQtd_dose();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Double getQtd_dose() {
        return qtd_dose;
    }

    public void setQtd_dose(Double qtd_dose) {
        this.qtd_dose = qtd_dose;
    }
}
