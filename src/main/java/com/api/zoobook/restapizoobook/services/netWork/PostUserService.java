package com.api.zoobook.restapizoobook.services.netWork;

import com.api.zoobook.restapizoobook.domain.socialNetwork.PostsUsuario;
import com.api.zoobook.restapizoobook.dto.PostsUsuarioDTO;
import com.api.zoobook.restapizoobook.exceptions.ObjectNotFoundException;
import com.api.zoobook.restapizoobook.repositores.PostUsuarioRepository;
import com.api.zoobook.restapizoobook.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostUserService {

    @Autowired
    private PostUsuarioRepository repo;

    @Autowired
    private ProfilePetService profilePetService;


    public PostsUsuario find(Integer id) {
        Optional<PostsUsuario> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + PostsUsuario.class.getName()));
    }

    public PostsUsuario insert(PostsUsuario obj) {
        obj.setId(null);
        obj.setBody(null);
        obj.setPosted_at(new Date());
        obj.setLikes(null);
        obj.setPostImg(null);
        obj.setTopics(null);
        obj.setProfilePet(profilePetService.findProfilePet(obj.getProfilePet().getId()));
        obj = repo.save(obj);
        return obj;
    }

    public PostsUsuario update(PostsUsuario obj) {
        PostsUsuario newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há relacionamento com outras entidades.");
        }
    }

    public List<PostsUsuario> findAll() {
        return repo.findAll();
    }


    public PostsUsuario fromDTO(PostsUsuarioDTO objDto) {
        return new PostsUsuario();
    }


    private void updateData(PostsUsuario newObj, PostsUsuario obj) {
        newObj.setBody(obj.getBody());
        newObj.setPosted_at(obj.getPosted_at());
        newObj.setLikes(obj.getLikes());
        newObj.setPostImg(obj.getPostImg());
        newObj.setTopics(obj.getTopics());
    }
}
