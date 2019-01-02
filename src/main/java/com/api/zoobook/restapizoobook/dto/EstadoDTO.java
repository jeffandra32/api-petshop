package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.Estado;

import java.io.Serializable;

public class EstadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public EstadoDTO() {
    }

    public EstadoDTO(Estado obj) {
        id = obj.getId();
        name = obj.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
