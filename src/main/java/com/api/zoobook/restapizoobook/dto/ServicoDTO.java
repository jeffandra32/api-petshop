package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.Servico;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;


public class ServicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Este campo é obrigatorio!")
    private String descricao;
    @NotEmpty(message = "Este campo é obrigatorio!")
    private Double valor;

    @JsonFormat(pattern="HH:mm")
    @NotEmpty(message = "Este campo é obrigatorio!")
    private Date duracao;

    public ServicoDTO() {
    }

    public ServicoDTO(Servico obj) {
        id = obj.getId();
        descricao = obj.getDescricao();
        valor = obj.getValor();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDuracao() {
        return duracao;
    }

    public void setDuracao(Date duracao) {
        this.duracao = duracao;
    }
}
