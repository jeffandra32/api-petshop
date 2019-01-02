package com.api.zoobook.restapizoobook.services.netWork;

import com.api.zoobook.restapizoobook.domain.Usuario;
import com.api.zoobook.restapizoobook.domain.socialNetwork.ProfileFornecedor;
import com.api.zoobook.restapizoobook.domain.socialNetwork.ProfilePet;
import com.api.zoobook.restapizoobook.dto.ProfileFornecedorDTO;
import com.api.zoobook.restapizoobook.dto.ProfilePetDTO;
import com.api.zoobook.restapizoobook.exceptions.ObjectNotFoundException;
import com.api.zoobook.restapizoobook.repositores.ProfileFornecedorRepository;
import com.api.zoobook.restapizoobook.repositores.ProfilePetRepository;
import com.api.zoobook.restapizoobook.services.ClienteService;
import com.api.zoobook.restapizoobook.services.PetService;
import com.api.zoobook.restapizoobook.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileFornecedorService {

    @Autowired
    private ProfileFornecedorRepository repo;

    @Autowired
    private ClienteService clienteService;


    public ProfileFornecedor findProfileFornecedor(Integer id) {
        Optional<ProfileFornecedor> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + ProfileFornecedor.class.getName()));
    }

    public ProfileFornecedor insertProfileFornecedor(ProfileFornecedor obj) {
        obj.setId(null);
        obj.setUsuario(clienteService.find(obj.getUsuario().getId()));
        obj = repo.save(obj);
        return obj;
    }

    public ProfileFornecedor updateProfileFornecedor(ProfileFornecedor obj) {
        ProfileFornecedor newObj = findProfileFornecedor(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void deleteProfileFornecedor(Integer id) {
        findProfileFornecedor(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há relacionamento com outras entidades.");
        }
    }

    public List<ProfileFornecedor> findAll() {
        return repo.findAll();
    }


    public ProfileFornecedor fromDTO(ProfileFornecedorDTO objDto) {
        return new ProfileFornecedor();
    }


    private void updateData(ProfileFornecedor newObj, ProfileFornecedor obj) {
        newObj.setUsuario(obj.getUsuario());
    }
}
