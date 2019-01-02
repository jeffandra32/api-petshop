package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.DBFile;
import com.api.zoobook.restapizoobook.domain.pet.Pet;
import com.api.zoobook.restapizoobook.domain.pet.Prontuario;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


public class ProntuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    private String vet;

    @NotEmpty(message="Preenchimento obrigatório")
    private String address;

    @NotEmpty(message="Preenchimento obrigatório")
    private String number;

    private String complement;

    @NotEmpty(message="Preenchimento obrigatório")
    private String neighborhood;

    @NotEmpty(message="Preenchimento obrigatório")
    private String cep;

    private DBFile dbFile;

    private Pet pet;

    public ProntuarioDTO() {
    }

    public ProntuarioDTO(Prontuario obj) {
        id = obj.getId();
        vet = obj.getVet();
        address = obj.getAddress();
        number = obj.getNumber();
        complement = obj.getComplement();
        neighborhood = obj.getNeighborhood();
        cep = obj.getCep();
        dbFile = obj.getDbFile();
        pet = obj.getPet();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVet() {
        return vet;
    }

    public void setVet(String vet) {
        this.vet = vet;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public DBFile getDbFile() {
        return dbFile;
    }

    public void setDbFile(DBFile dbFile) {
        this.dbFile = dbFile;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
