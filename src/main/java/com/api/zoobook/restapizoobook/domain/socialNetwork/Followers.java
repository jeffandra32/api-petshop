package com.api.zoobook.restapizoobook.domain.socialNetwork;

import com.api.zoobook.restapizoobook.domain.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Followers implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;


    private Integer followers_id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="profile_pet_id")
    private ProfilePet profilePet;

    public Followers() {
    }

    public Followers(Integer id, Integer followers_id, ProfilePet profilePet) {
        this.id = id;
        this.followers_id = followers_id;
        this.profilePet = profilePet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Followers followers = (Followers) o;
        return Objects.equals(id, followers.id);
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

    public Integer getFollowers_id() {
        return followers_id;
    }

    public void setFollowers_id(Integer followers_id) {
        this.followers_id = followers_id;
    }

    public ProfilePet getProfilePet() {
        return profilePet;
    }

    public void setProfilePet(ProfilePet profilePet) {
        this.profilePet = profilePet;
    }
}
