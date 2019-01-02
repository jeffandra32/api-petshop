package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.pet.Pet;
import com.api.zoobook.restapizoobook.domain.socialNetwork.Followers;
import com.api.zoobook.restapizoobook.domain.socialNetwork.PostsUsuario;
import com.api.zoobook.restapizoobook.domain.socialNetwork.ProfilePet;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ProfilePetDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @OneToOne
    @JoinColumn(name="pet_id")
    private Pet pet;

    @JsonIgnore
    @OneToMany(mappedBy="profilePet")
    private List<PostsUsuario> postsUsuarios = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy="profilePet")
    private List<Followers> followers = new ArrayList<>();

    public ProfilePetDTO() {
    }

    public ProfilePetDTO(ProfilePet obj) {
        id = obj.getId();
        pet = obj.getPet();
       postsUsuarios = obj.getPostsUsuarios();
       followers = obj.getFollowers();

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
