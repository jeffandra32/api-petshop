package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.Agenda;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;


public class AgendaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer agenda_id;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    @NotEmpty(message = "Este campo é obrigatorio!")
    private Date data;

    @JsonFormat(pattern="HH:mm")
    @NotEmpty(message = "Este campo é obrigatorio!")
    private Date hora;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    @NotEmpty(message = "Este campo é obrigatorio!")
    private Date entrada;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    @NotEmpty(message = "Este campo é obrigatorio!")
    private Date saida;

    @NotEmpty(message = "Este campo é obrigatorio!")
    private String animal;

    @NotEmpty(message = "Este campo é obrigatorio!")
    private String status;

    public AgendaDTO() {
    }

    public AgendaDTO(Agenda obj) {
        agenda_id = obj.getAgenda_id();
        data = obj.getData();
        hora = obj.getHora();
        entrada = obj.getEntrada();
        saida = obj.getSaida();
        animal = obj.getAnimal();
        status = obj.getStatus();
    }

    public Integer getAgenda_id() {
        return agenda_id;
    }

    public void setAgenda_id(Integer agenda_id) {
        this.agenda_id = agenda_id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
