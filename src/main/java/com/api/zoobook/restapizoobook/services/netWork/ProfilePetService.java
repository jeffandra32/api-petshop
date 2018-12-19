package com.api.zoobook.restapizoobook.services.netWork;

import com.api.zoobook.restapizoobook.domain.socialNetwork.ProfilePet;
import com.api.zoobook.restapizoobook.dto.ProfilePetDTO;
import com.api.zoobook.restapizoobook.exceptions.ObjectNotFoundException;
import com.api.zoobook.restapizoobook.repositores.ProfilePetRepository;
import com.api.zoobook.restapizoobook.services.PetService;
import com.api.zoobook.restapizoobook.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfilePetService {

    @Autowired
    private ProfilePetRepository repo;

    @Autowired
    private PetService petService;


    public ProfilePet findProfilePet(Integer id) {
        Optional<ProfilePet> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + ProfilePet.class.getName()));
    }

    public ProfilePet insertProfilePet(ProfilePet obj) {
        obj.setId(null);
        obj.setPet(petService.find(obj.getPet().getId()));
        obj = repo.save(obj);
        return obj;
    }

    public ProfilePet updateProfilePet(ProfilePet obj) {
        ProfilePet newObj = findProfilePet(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void deleteProfilePet(Integer id) {
        findProfilePet(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há relacionamento com outras entidades.");
        }
    }

    public List<ProfilePet> findAll() {
        return repo.findAll();
    }


    public ProfilePet fromDTO(ProfilePetDTO objDto) {
        return new ProfilePet();
    }


    private void updateData(ProfilePet newObj, ProfilePet obj) {
        newObj.setPet(obj.getPet());
    }
}
