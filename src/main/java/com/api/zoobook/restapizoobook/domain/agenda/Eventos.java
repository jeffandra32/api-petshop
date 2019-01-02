package com.api.zoobook.restapizoobook.domain.agenda;
import com.api.zoobook.restapizoobook.domain.servico.Servico;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Eventos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo obrigatório!")
    private String title;
    @NotEmpty(message = "Campo obrigatório!")
    private String start;
    @NotEmpty(message = "Campo obrigatório!")
    private String end;


    @OneToMany(mappedBy="eventos")
    private List<Servico> servicos = new ArrayList<>();

    public Eventos(){

    }

    public Eventos(Integer id, String title, String start, String end) {
        super();
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eventos that = (Eventos) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
