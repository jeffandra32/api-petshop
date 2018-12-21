package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.DBFile;
import com.api.zoobook.restapizoobook.domain.Pet;
import com.api.zoobook.restapizoobook.domain.Prontuario;

import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.io.Serializable;


public class ProntuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    private String veterinario;

    @NotEmpty(message="Preenchimento obrigatório")
    private String logradouro;

    @NotEmpty(message="Preenchimento obrigatório")
    private String numero;

    private String complemento;

    @NotEmpty(message="Preenchimento obrigatório")
    private String bairro;

    @NotEmpty(message="Preenchimento obrigatório")
    private String cep;

    private DBFile dbFile;

    private Pet pet;

    public ProntuarioDTO() {
    }

    public ProntuarioDTO(Prontuario obj) {
        id = obj.getId();
        veterinario = obj.getVeterinario();
        logradouro = obj.getLogradouro();
        numero = obj.getNumero();
        complemento = obj.getComplemento();
        bairro = obj.getBairro();
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

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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
