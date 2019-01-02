package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.Usuario;
import com.api.zoobook.restapizoobook.domain.socialNetwork.Followers;
import com.api.zoobook.restapizoobook.domain.socialNetwork.PostsUsuario;
import com.api.zoobook.restapizoobook.domain.socialNetwork.ProfileFornecedor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ProfileFornecedorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @OneToOne
    @JoinColumn(name="cliente_id")
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy="profileFornecedor")
    private List<PostsUsuario> postsUsuarios = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy="profileFornecedor")
    private List<Followers> followers = new ArrayList<>();

    public ProfileFornecedorDTO() {
    }

    public ProfileFornecedorDTO(ProfileFornecedor obj) {
        id = obj.getId();
        usuario = obj.getUsuario();
        postsUsuarios = obj.getPostsUsuarios();
        followers = obj.getFollowers();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<PostsUsuario> getPostsUsuarios() {
        return postsUsuarios;
    }

    public void setPostsUsuarios(List<PostsUsuario> postsUsuarios) {
        this.postsUsuarios = postsUsuarios;
    }

    public List<Followers> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Followers> followers) {
        this.followers = followers;
    }
}
