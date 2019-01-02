package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.pet.Pet;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;


public class PetDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String name;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=50, message="O tamanho deve ser entre 5 e 50 caracteres")
    private String breed;

    private Integer age;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;

    private double weight;

    @NotEmpty(message="Preenchimento obrigatório")
    private String filiation;

    @NotEmpty(message="Preenchimento obrigatório")
    private boolean acceptRelationship;

    @NotEmpty(message="Preenchimento obrigatório")
    private boolean donation;

    @NotEmpty(message="Preenchimento obrigatório")
    private Integer type;

    private String imageUrl;

    public PetDTO() {
    }

    public PetDTO(Pet obj) {
        id = obj.getId();
        name = obj.getName();
        breed = obj.getBreed();
        age = obj.getAge();
        birthDate = obj.getBirthDate();
        weight = obj.getWeight();
        filiation = obj.getFiliation();
        type = obj.getType();
        acceptRelationship = obj.isAcceptRelationship();
        donation = obj.isDonation();
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
