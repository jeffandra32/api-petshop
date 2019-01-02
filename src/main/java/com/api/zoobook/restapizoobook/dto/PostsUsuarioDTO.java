package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.socialNetwork.PostsUsuario;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;


public class PostsUsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;

    @NotEmpty(message = "Campo obrigatório!")
    private String body;

    @NotEmpty(message = "Campo obrigatório!")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date posted_at;

    private Integer likes;

    private String postImg;

    private String topics;


    public PostsUsuarioDTO() {
    }

    public PostsUsuarioDTO(PostsUsuario obj) {

        id = obj.getId();
        posted_at = obj.getPosted_at();
        likes = obj.getLikes();
        topics = obj.getTopics();
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


}
