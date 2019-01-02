package com.api.zoobook.restapizoobook.services.netWork;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.api.zoobook.restapizoobook.domain.socialNetwork.PostLikes;
import com.api.zoobook.restapizoobook.exceptions.ObjectNotFoundException;
import com.api.zoobook.restapizoobook.repositores.PostLikesRepository;
import com.api.zoobook.restapizoobook.services.exceptions.DataIntegrityException;

@Service
public class PostLikesService {

    @Autowired
    private PostLikesRepository repo;

    @Autowired
    private ProfilePetService profilePetService;

    @Autowired
    private PostUserService postUserService;


    public PostLikes findLike(Integer id) {
        Optional<PostLikes> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + PostLikes.class.getName()));
    }

    public PostLikes insertLike(PostLikes obj) {
        obj.setId(null);
        obj.setProfilePet(profilePetService.findProfilePet(obj.getProfilePet().getId()));
        obj.setPostsUsuario(postUserService.find(obj.getPostsUsuario().getId()));
        obj = repo.save(obj);
        return obj;
    }

    public void deleteLike(Integer id) {
        findLike(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há relacionamento com outras entidades.");
        }
    }

}
