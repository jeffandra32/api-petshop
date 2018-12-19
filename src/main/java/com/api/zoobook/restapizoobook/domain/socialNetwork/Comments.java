package com.api.zoobook.restapizoobook.domain.socialNetwork;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Comments implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String comment;
    private Date posted_at;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="profile_pet_id")
    private ProfilePet profilePet;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="post_cliente_id")
    private PostsUsuario postsUsuario;

    public Comments() {
    }

    public Comments(Integer id, String comment, Date posted_at, ProfilePet profilePet, PostsUsuario postsUsuario) {
        this.id = id;
        this.comment = comment;
        this.posted_at = posted_at;
        this.profilePet = profilePet;
        this.postsUsuario = postsUsuario;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return Objects.equals(id, comments.id);
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getPosted_at() {
        return posted_at;
    }

    public void setPosted_at(Date posted_at) {
        this.posted_at = posted_at;
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
