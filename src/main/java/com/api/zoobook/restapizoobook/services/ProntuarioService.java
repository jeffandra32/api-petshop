package com.api.zoobook.restapizoobook.services;

import com.api.zoobook.restapizoobook.domain.Prontuario;
import com.api.zoobook.restapizoobook.dto.ProntuarioDTO;
import com.api.zoobook.restapizoobook.exceptions.ObjectNotFoundException;
import com.api.zoobook.restapizoobook.repositores.ProntuarioRepository;
import com.api.zoobook.restapizoobook.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProntuarioService {

    @Autowired
    private ProntuarioRepository repo;

    @Autowired
    private PetService petService;

    @Autowired
    private ClienteService clienteService;


    public Prontuario find(Integer id) {
        Optional<Prontuario> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Prontuario.class.getName()));
    }

    public Prontuario insert(Prontuario obj) {
        obj.setId(null);
        obj.setVeterinario(null);
        obj.setLogradouro(null);
        obj.setNumero(null);
        obj.setComplemento(null);
        obj.setBairro(null);
        obj.setCep(null);
        obj.setDbFile(null);
        obj.setPet(petService.find(obj.getPet().getId()));
        obj = repo.save(obj);
        return obj;
    }

    public Prontuario update(Prontuario obj) {
        Prontuario newObj = find(obj.getId());
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

    public List<Prontuario> findAll() {
        return repo.findAll();
    }


    public Prontuario fromDTO(ProntuarioDTO objDto) {
        return new Prontuario(objDto.getId(), objDto.getVeterinario(), objDto.getLogradouro(),
                objDto.getNumero(), objDto.getComplemento(),
                objDto.getBairro(), objDto.getCep(), objDto.getDbFile(), objDto.getPet());
    }


    private void updateData(Prontuario newObj, Prontuario obj) {
        newObj.setVeterinario(obj.getVeterinario());
        newObj.setLogradouro(obj.getLogradouro());
        newObj.setNumero(obj.getNumero());
        newObj.setComplemento(obj.getComplemento());
        newObj.setBairro(obj.getBairro());
        newObj.setCep(obj.getCep());
        newObj.setDbFile(obj.getDbFile());
        newObj.setTelefones(obj.getTelefones());
    }
}
