package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.Prontuario;

import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.io.Serializable;


public class ProntuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    //@NotEmpty(message="Preenchimento obrigatório")
    private String veterinario;

    //@NotEmpty(message="Preenchimento obrigatório")
    private String logradouro;

    //@NotEmpty(message="Preenchimento obrigatório")
    private String numero;
    private String complemento;

    //@NotEmpty(message="Preenchimento obrigatório")
    private String bairro;

    //@NotEmpty(message="Preenchimento obrigatório")
    private String cep;

    private File exames;

    //@NotEmpty(message="Preenchimento obrigatório")
    private String telefone1;

    private String telefone2;

    private String telefone3;

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
        exames = obj.getExames();
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

    public File getExames() {
        return exames;
    }

    public void setExames(File exames) {
        this.exames = exames;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }
}
