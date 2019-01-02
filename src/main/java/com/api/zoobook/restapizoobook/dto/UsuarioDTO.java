package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.Usuario;
import com.api.zoobook.restapizoobook.services.validation.ClienteUpdate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClienteUpdate
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String name;

    @NotEmpty(message="Preenchimento obrigatório")
    @Email(message="Email inválido")
    private String email;



    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
