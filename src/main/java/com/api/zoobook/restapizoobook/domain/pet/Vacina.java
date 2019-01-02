package com.api.zoobook.restapizoobook.domain.pet;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Vacina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String type;

    private String priority;

    private Double qtd_dose;

    @ManyToOne
    @JoinColumn(name="prontuario_id")
    private Prontuario prontuario;

    public Vacina() {
    }

    public Vacina(Integer id, String type, String priority, Double qtd_dose, Prontuario prontuario) {
        this.id = id;
        this.type = type;
        this.priority = priority;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
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
