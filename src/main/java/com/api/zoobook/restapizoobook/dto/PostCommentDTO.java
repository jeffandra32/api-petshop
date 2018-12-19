package com.api.zoobook.restapizoobook.dto;

import com.api.zoobook.restapizoobook.domain.socialNetwork.Comments;
import com.api.zoobook.restapizoobook.domain.socialNetwork.ProfilePet;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;


public class PostCommentDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;

    @NotEmpty(message = "Campo obrigatório!")
    private String comment;

    @NotEmpty(message = "Campo obrigatório!")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date posted_at;


    public PostCommentDTO() {
    }

    public PostCommentDTO(Comments obj) {

        id = obj.getId();
        comment = obj.getComment();
        posted_at = obj.getPosted_at();

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


}
