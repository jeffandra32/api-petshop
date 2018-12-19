package com.api.zoobook.restapizoobook.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer agenda_id;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date data;

    @JsonFormat(pattern="HH:mm")
    private Date hora;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date entrada;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date saida;
    
    private String animal;
    private String status;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @JsonIgnore
    @OneToMany(mappedBy="agenda")
    private List<Servico> servicos = new ArrayList<>();

    public Agenda() {
    }

    public Agenda(Integer agenda_id, Date data, Date hora, Date entrada, Date saida, String animal, String status, Cliente cliente) {
        this.agenda_id = agenda_id;
        this.data = data;
        this.hora = hora;
        this.entrada = entrada;
        this.saida = saida;
        this.animal = animal;
        this.status = status;
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agenda agenda = (Agenda) o;
        return Objects.equals(agenda_id, agenda.agenda_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agenda_id);
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
