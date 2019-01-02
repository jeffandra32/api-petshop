package com.api.zoobook.restapizoobook.domain.socialNetwork;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class TimeLine implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="profile_pet_id")
    private ProfilePet profilePet;

    @ManyToOne
    @JoinColumn(name="profile_fornecedor_id")
    private ProfileFornecedor profileFornecedor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="posts_usuario_id")
    private PostsUsuario postsUsuario;

    public TimeLine() {
    }

    public TimeLine(Integer id, String body, Date posted_at, Integer likes, String postImg, String topics, ProfilePet profilePet, ProfileFornecedor profileFornecedor, PostsUsuario postsUsuario) {
        this.id = id;
        this.profilePet = profilePet;
        this.profileFornecedor = profileFornecedor;
        this.postsUsuario = postsUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeLine that = (TimeLine) o;
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



    public ProfilePet getProfilePet() {
        return profilePet;
    }

    public void setProfilePet(ProfilePet profilePet) {
        this.profilePet = profilePet;
    }

    public ProfileFornecedor getProfileFornecedor() {
        return profileFornecedor;
    }

    public void setProfileFornecedor(ProfileFornecedor profileFornecedor) {
        this.profileFornecedor = profileFornecedor;
    }

    public PostsUsuario getPostsUsuario() {
        return postsUsuario;
    }

    public void setPostsUsuario(PostsUsuario postsUsuario) {
        this.postsUsuario = postsUsuario;
    }
}
