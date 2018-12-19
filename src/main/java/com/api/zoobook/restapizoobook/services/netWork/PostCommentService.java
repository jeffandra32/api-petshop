package com.api.zoobook.restapizoobook.services.netWork;

import com.api.zoobook.restapizoobook.domain.socialNetwork.Comments;
import com.api.zoobook.restapizoobook.dto.PostCommentDTO;
import com.api.zoobook.restapizoobook.exceptions.ObjectNotFoundException;
import com.api.zoobook.restapizoobook.repositores.PostCommentRepository;
import com.api.zoobook.restapizoobook.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostCommentService {

    @Autowired
    private PostCommentRepository repo;

    @Autowired
    private ProfilePetService profilePetService;

    @Autowired
    private PostUserService postUserService;


    public Comments findComment(Integer id) {
        Optional<Comments> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Comments.class.getName()));
    }

    public Comments insertComment(Comments obj) {
        obj.setId(null);
        obj.setComment(null);
        obj.setPosted_at(new Date());
        obj.setProfilePet(profilePetService.findProfilePet(obj.getProfilePet().getId()));
        obj.setPostsUsuario(postUserService.find(obj.getPostsUsuario().getId()));
        obj = repo.save(obj);
        return obj;
    }

    public Comments updateComment(Comments obj) {
        Comments newObj = findComment(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void deleteComment(Integer id) {
        findComment(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há relacionamento com outras entidades.");
        }
    }

    public List<Comments> findAll() {
        return repo.findAll();
    }


    public Comments fromDTO(PostCommentDTO objDto) {
        return new Comments();
    }


    private void updateData(Comments newObj, Comments obj) {
        newObj.setComment(obj.getComment());
        newObj.setPosted_at(obj.getPosted_at());
    }
}
