package com.api.zoobook.restapizoobook.services.netWork;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.api.zoobook.restapizoobook.domain.socialNetwork.Followers;
import com.api.zoobook.restapizoobook.exceptions.ObjectNotFoundException;
import com.api.zoobook.restapizoobook.repositores.FollowersRepository;
import com.api.zoobook.restapizoobook.services.exceptions.DataIntegrityException;

@Service
public class FollowersService {

    @Autowired
    private FollowersRepository repo;

    @Autowired
    private ProfilePetService profilePetService;


    public Followers findFollower(Integer id) {
        Optional<Followers> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Followers.class.getName()));
    }

    public Followers insertFollower(Followers obj) {
        obj.setId(null);
        obj.setFollowers_id(null);
        obj.setProfilePet(profilePetService.findProfilePet(obj.getProfilePet().getId()));
        obj = repo.save(obj);
        return obj;
    }

    public void deleteFollower(Integer id) {
        findFollower(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há relacionamento com outras entidades.");
        }
    }

}
