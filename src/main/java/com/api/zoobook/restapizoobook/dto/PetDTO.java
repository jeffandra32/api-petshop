package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.Cliente;
import com.api.zoobook.restapizoobook.domain.Pet;
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
    private String nome;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=50, message="O tamanho deve ser entre 5 e 50 caracteres")
    private String raca;

    private Integer idade;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data_nascimento;

    private double peso;

    @NotEmpty(message="Preenchimento obrigatório")
    private String filiacao;

    @NotEmpty(message="Preenchimento obrigatório")
    private boolean aceita_relacionamento;

    @NotEmpty(message="Preenchimento obrigatório")
    private boolean doacao;

    private String foto;

    @NotEmpty(message="Preenchimento obrigatório")
    private Integer tipo;





    public PetDTO() {
    }

    public PetDTO(Pet obj) {
        id = obj.getId();
        nome = obj.getNome();
        raca = obj.getRaça();
        idade = obj.getIdade();
        data_nascimento = obj.getData_nascimento();
        peso = obj.getPeso();
        filiacao = obj.getFiliacao();
        tipo = obj.getTipo();
        aceita_relacionamento = obj.isAceita_relacionamento();
        doacao = obj.isDoacao();
        foto = obj.getFoto();



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

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
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

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


}
