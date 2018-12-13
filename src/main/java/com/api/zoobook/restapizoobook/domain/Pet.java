package com.api.zoobook.restapizoobook.domain;

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


    private String nome;

    private String raça;

    private int idade;

    private Date data_nascimento;

    private double peso;

    private String filiacao;

    private boolean aceita_relacionamento;

    private boolean doacao;

    @JsonIgnore
    @ManyToMany
    @JoinColumn(name="pet_id")
    private List<PetCategoria> petCategorias = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    public Pet() {
    }

    public Pet(Integer id, String nome, int tipo, String raça, int idade, Date data_nascimento, double peso, String filiacao, boolean aceita_relacionamento, boolean doacao, Cliente cliente) {
        this.id = id;
        this.nome = nome;
        this.raça = raça;
        this.idade = idade;
        this.data_nascimento = data_nascimento;
        this.peso = peso;
        this.filiacao = filiacao;
        this.aceita_relacionamento = aceita_relacionamento;
        this.doacao = doacao;
        this.cliente = cliente;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }

    public boolean isAceita_relacionamento() {
        return aceita_relacionamento;
    }

    public void setAceita_relacionamento(boolean aceita_relacionamento) {
        this.aceita_relacionamento = aceita_relacionamento;
    }

    public boolean isDoacao() {
        return doacao;
    }

    public void setDoacao(boolean doacao) {
        this.doacao = doacao;
    }

    public List<PetCategoria> getPetCategoriascategorias() {
        return petCategorias;
    }

    public void setPetCategoriascategorias(List<PetCategoria> petCategoriascategorias) {
        this.petCategorias = petCategoriascategorias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
