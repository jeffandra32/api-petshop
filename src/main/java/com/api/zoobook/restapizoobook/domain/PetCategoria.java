package com.api.zoobook.restapizoobook.domain;

import com.api.zoobook.restapizoobook.domain.enums.TipoPet;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class PetCategoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer tipoPet;

    @ManyToMany(mappedBy="petCategorias")
    private List<Pet> pets = new ArrayList<>();

    public PetCategoria() {
    }

    public PetCategoria(Integer id, TipoPet tipoPet) {
        this.id = id;
        this.tipoPet = (tipoPet==null) ? null : tipoPet.getCod();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetCategoria that = (PetCategoria) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipoPet() {
        return tipoPet;
    }

    public void setTipoPet(Integer tipoPet) {
        this.tipoPet = tipoPet;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
