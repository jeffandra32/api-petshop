package com.api.zoobook.restapizoobook.domain.socialNetwork;

import com.api.zoobook.restapizoobook.domain.Pet;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ProfilePet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name="pet_id")
    private Pet pet;

    @OneToMany(mappedBy="profilePet")

    private List<PostsUsuario> postsUsuarios = new ArrayList<>();


    @OneToMany(mappedBy="profilePet")
    private List<Followers> followers = new ArrayList<>();

    public ProfilePet() {
    }

    public ProfilePet(Integer id, Pet pet) {
        this.id = id;
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfilePet that = (ProfilePet) o;
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
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
