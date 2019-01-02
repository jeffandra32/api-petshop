package com.api.zoobook.restapizoobook.domain.socialNetwork;

import com.api.zoobook.restapizoobook.domain.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ProfileFornecedor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy="profileFornecedor")

    private List<PostsUsuario> postsUsuarios = new ArrayList<>();


    @OneToMany(mappedBy="profileFornecedor")
    private List<Followers> followers = new ArrayList<>();

    public ProfileFornecedor() {
    }

    public ProfileFornecedor(Integer id, Usuario usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileFornecedor that = (ProfileFornecedor) o;
        return Objects.equals(id, that.id);
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
