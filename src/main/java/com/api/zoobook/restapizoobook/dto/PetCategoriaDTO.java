package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.PetCategoria;
import com.api.zoobook.restapizoobook.domain.enums.TipoPet;

import java.io.Serializable;

public class PetCategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private TipoPet tipoPet;

    public PetCategoriaDTO() {
    }

    public PetCategoriaDTO(PetCategoria obj) {
        id = obj.getId();
        tipoPet = getTipoPet();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoPet getTipoPet() {
        return tipoPet;
    }

    public void setTipoPet(TipoPet tipoPet) {
        this.tipoPet = tipoPet;
    }
}