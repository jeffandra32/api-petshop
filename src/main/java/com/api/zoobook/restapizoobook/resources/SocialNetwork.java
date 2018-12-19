package com.api.zoobook.restapizoobook.resources;


import com.api.zoobook.restapizoobook.domain.socialNetwork.*;
import com.api.zoobook.restapizoobook.dto.PostCommentDTO;
import com.api.zoobook.restapizoobook.dto.PostsUsuarioDTO;
import com.api.zoobook.restapizoobook.dto.ProfilePetDTO;
import com.api.zoobook.restapizoobook.services.netWork.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "v1/socialNetwork")
public class SocialNetwork {

    @Autowired
    private PostUserService service;

    @Autowired
    private PostLikesService service2;

    @Autowired
    private PostCommentService service3;

    @Autowired
    private FollowersService service4;

    @Autowired
    private ProfilePetService service5;


    /** ENDPOINT PARA POSTAGENS START*/

    @RequestMapping(value="/post/find/{id}", method=RequestMethod.GET)
    public ResponseEntity<PostsUsuario> find(@PathVariable Integer id) {
        PostsUsuario obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody PostsUsuario obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/post/update/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody PostsUsuarioDTO objDto, @PathVariable Integer id) {
        PostsUsuario obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/post/delete/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value="/post/list", method=RequestMethod.GET)
    public ResponseEntity<List<PostsUsuarioDTO>> findAll() {
        List<PostsUsuario> list = service.findAll();
        List<PostsUsuarioDTO> listDto = list.stream().map(obj -> new PostsUsuarioDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }



    /** ENDPOINT PARA LIKES START*/

    @RequestMapping(value="/likes/find/{id}", method=RequestMethod.GET)
    public ResponseEntity<PostLikes> findLike(@PathVariable Integer id) {
        PostLikes obj = service2.findLike(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/likes/insert", method=RequestMethod.POST)
    public ResponseEntity<Void> insertLike(@Valid @RequestBody PostLikes obj) {
        obj = service2.insertLike(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/likes/delete/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteLike(@PathVariable Integer id) {
        service2.deleteLike(id);
        return ResponseEntity.noContent().build();
    }



    /** ENDPOINT PARA COMMENTS START*/

    @RequestMapping(value="/comment/find/{id}", method=RequestMethod.GET)
    public ResponseEntity<Comments> findComments(@PathVariable Integer id) {
        Comments obj = service3.findComment(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/comment/insert", method=RequestMethod.POST)
    public ResponseEntity<Void> insertComment(@Valid @RequestBody Comments obj) {
        obj = service3.insertComment(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/comment/update/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> updateComment(@Valid @RequestBody PostCommentDTO objDto, @PathVariable Integer id) {
        Comments obj = service3.fromDTO(objDto);
        obj.setId(id);
        obj = service3.updateComment(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/comment/delete/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id) {
        service3.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/comment/list", method=RequestMethod.GET)
    public ResponseEntity<List<PostCommentDTO>> findAllComment() {
        List<Comments> list = service3.findAll();
        List<PostCommentDTO> listDto = list.stream().map(obj -> new PostCommentDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }





    /** ENDPOINT PARA FOLLOWER START*/

    @RequestMapping(value="/follower/find/{id}", method=RequestMethod.GET)
    public ResponseEntity<Followers> findFollower(@PathVariable Integer id) {
        Followers obj = service4.findFollower(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/follower/insert", method=RequestMethod.POST)
    public ResponseEntity<Void> insertFollower(@Valid @RequestBody Followers obj) {
        obj = service4.insertFollower(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/follower/delete/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteFollower(@PathVariable Integer id) {
        service4.deleteFollower(id);
        return ResponseEntity.noContent().build();
    }

    /** ENDPOINT PARA PROFILE_PET START*/


    @RequestMapping(value="/profilePet/find/{id}", method=RequestMethod.GET)
    public ResponseEntity<ProfilePet> findProfilePet(@PathVariable Integer id) {
        ProfilePet obj = service5.findProfilePet(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/profilePet/insert", method=RequestMethod.POST)
    public ResponseEntity<Void> insertProfilePet(@Valid @RequestBody ProfilePet obj) {
        obj = service5.insertProfilePet(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/profilePet/update/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> updateProfilePet(@Valid @RequestBody ProfilePetDTO objDto, @PathVariable Integer id) {
        ProfilePet obj = service5.fromDTO(objDto);
        obj.setId(id);
        obj = service5.updateProfilePet(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/profilePet/delete/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProfilePet(@PathVariable Integer id) {
        service5.deleteProfilePet(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/profilePet/list", method=RequestMethod.GET)
    public ResponseEntity<List<ProfilePetDTO>> findAllProfilePet() {
        List<ProfilePet> list = service5.findAll();
        List<ProfilePetDTO> listDto = list.stream().map(obj -> new ProfilePetDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

}
