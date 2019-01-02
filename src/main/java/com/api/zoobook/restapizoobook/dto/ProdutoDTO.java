package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.servico.Produto;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Campo obrigatótio!")
    private String name;
    @NotEmpty(message = "Campo obrigatótio!")
    private Double price;
    private String imageUrl;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto obj) {
        id = obj.getId();
        name = obj.getName();
        price = obj.getPrice();
        imageUrl = obj.getImageUrl();
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
