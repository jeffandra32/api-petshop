package com.api.zoobook.restapizoobook.domain.socialNetwork;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class PostsUsuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;


    private String body;

    private Date posted_at;

    private Integer likes;

    private String postImg;

    private String topics;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="profile_pet_id")
    private ProfilePet profilePet;

    @OneToMany(mappedBy="postsUsuario")
    private List<PostLikes> postLikes = new ArrayList<>();

    @OneToMany(mappedBy="postsUsuario")
    private List<Comments> comments = new ArrayList<>();

    public PostsUsuario() {
    }

    public PostsUsuario(Integer id, String body, Date posted_at, Integer likes, String postImg, String topics, ProfilePet profilePet) {
        this.id = id;
        this.body = body;
        this.posted_at = posted_at;
        this.likes = likes;
        this.postImg = postImg;
        this.topics = topics;
        this.profilePet = profilePet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostsUsuario that = (PostsUsuario) o;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getPosted_at() {
        return posted_at;
    }

    public void setPosted_at(Date posted_at) {
        this.posted_at = posted_at;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public ProfilePet getProfilePet() {
        return profilePet;
    }

    public void setProfilePet(ProfilePet profilePet) {
        this.profilePet = profilePet;
    }

    public List<PostLikes> getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(List<PostLikes> postLikes) {
        this.postLikes = postLikes;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
}
