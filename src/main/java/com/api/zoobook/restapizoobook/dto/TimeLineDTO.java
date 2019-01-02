package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.socialNetwork.PostsUsuario;
import com.api.zoobook.restapizoobook.domain.socialNetwork.ProfileFornecedor;
import com.api.zoobook.restapizoobook.domain.socialNetwork.ProfilePet;

import java.io.Serializable;


public class TimeLineDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;

   private ProfileFornecedor profileFornecedor;

   private ProfilePet profilePet;

   private PostsUsuario postsUsuario;


    public TimeLineDTO() {
    }

    public TimeLineDTO(PostsUsuario obj) {

        id = obj.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProfileFornecedor getProfileFornecedor() {
        return profileFornecedor;
    }

    public void setProfileFornecedor(ProfileFornecedor profileFornecedor) {
        this.profileFornecedor = profileFornecedor;
    }

    public ProfilePet getProfilePet() {
        return profilePet;
    }

    public void setProfilePet(ProfilePet profilePet) {
        this.profilePet = profilePet;
    }

    public PostsUsuario getPostsUsuario() {
        return postsUsuario;
    }

    public void setPostsUsuario(PostsUsuario postsUsuario) {
        this.postsUsuario = postsUsuario;
    }
}
