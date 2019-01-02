package com.api.zoobook.restapizoobook.services.netWork;

import com.api.zoobook.restapizoobook.domain.socialNetwork.TimeLine;
import com.api.zoobook.restapizoobook.dto.TimeLineDTO;
import com.api.zoobook.restapizoobook.exceptions.ObjectNotFoundException;
import com.api.zoobook.restapizoobook.repositores.TimeLineRepository;
import com.api.zoobook.restapizoobook.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeLineService {

    @Autowired
    private TimeLineRepository repo;

    @Autowired
    private ProfilePetService profilePetService;

    @Autowired
    private ProfileFornecedorService profileFornecedorService;

    @Autowired
    private PostUserService postUserService;


    public TimeLine find(Integer id) {
        Optional<TimeLine> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + TimeLine.class.getName()));
    }

    public TimeLine insert(TimeLine obj) {
        obj.setId(null);
        obj.setProfilePet(profilePetService.findProfilePet(obj.getProfilePet().getId()));
        obj.setProfileFornecedor(profileFornecedorService.findProfileFornecedor(obj.getProfileFornecedor().getId()));
        obj.setPostsUsuario(null);
        obj = repo.save(obj);
        return obj;
    }

    public TimeLine update(TimeLine obj) {
        TimeLine newObj = find(obj.getId());
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

    public List<TimeLine> findAll() {
        return repo.findAll();
    }


    public TimeLine fromDTO(TimeLineDTO objDto) {
        return new TimeLine();
    }


    private void updateData(TimeLine newObj, TimeLine obj) {
        newObj.setPostsUsuario(obj.getPostsUsuario());
    }
}
