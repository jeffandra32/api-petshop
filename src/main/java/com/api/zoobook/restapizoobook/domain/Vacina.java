package com.api.zoobook.restapizoobook.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Vacina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String tipo;

    private String prioridade;

    private Double qtd_dose;

    @ManyToOne
    @JoinColumn(name="prontuario_id")
    private Prontuario prontuario;

    public Vacina() {
    }

    public Vacina(Integer id, String tipo, String prioridade, Double qtd_dose, Prontuario prontuario) {
        this.id = id;
        this.tipo = tipo;
        this.prioridade = prioridade;
        this.qtd_dose = qtd_dose;
        this.prontuario = prontuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacina vacina = (Vacina) o;
        return Objects.equals(id, vacina.id);
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Double getQtd_dose() {
        return qtd_dose;
    }

    public void setQtd_dose(Double qtd_dose) {
        this.qtd_dose = qtd_dose;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
}
