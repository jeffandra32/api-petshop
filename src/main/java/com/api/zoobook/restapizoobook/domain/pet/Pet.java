package com.api.zoobook.restapizoobook.domain.pet;

import com.api.zoobook.restapizoobook.domain.Usuario;
import com.api.zoobook.restapizoobook.domain.enums.TipoPet;
import com.api.zoobook.restapizoobook.domain.socialNetwork.ProfilePet;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    /*
    *  nome
    *  raça
    *  idade
    *  data_aniversário
    *  peso
    *  filiação
    *  aceita_relacionameto
    *  doação
    *  imageUrl
    *  tipo
    * */

    private String name;
    private String breed;
    private Integer age;
    private Date birthDate;
    private double weight;
    private String filiation;
    private boolean acceptRelationship;
    private boolean donation;
    private String imageUrl;
    private Integer type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Usuario usuario;

    @JsonIgnore
    @OneToOne
    private ProfilePet profilePet;

    @JsonIgnore
    @OneToMany(mappedBy="pet")
    private List<Prontuario> prontuarios = new ArrayList<>();

    public Pet() {
    }

    public Pet(Integer id, String name, String breed, Integer age, Date birthDate, double weight, String filiation, TipoPet type, boolean acceptRelationship, boolean donation, Usuario usuario) {
        super();
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.birthDate = birthDate;
        this.weight = weight;
        this.filiation = filiation;
        this.type = (type==null) ? null : type.getCod();
        this.acceptRelationship = acceptRelationship;
        this.donation = donation;
        this.usuario = usuario;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id);
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Prontuario> getProntuarios() {
        return prontuarios;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getFiliation() {
        return filiation;
    }

    public void setFiliation(String filiation) {
        this.filiation = filiation;
    }

    public boolean isAcceptRelationship() {
        return acceptRelationship;
    }

    public void setAcceptRelationship(boolean acceptRelationship) {
        this.acceptRelationship = acceptRelationship;
    }

    public boolean isDonation() {
        return donation;
    }

    public void setDonation(boolean donation) {
        this.donation = donation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
