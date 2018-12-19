package com.api.zoobook.restapizoobook.services;

import com.api.zoobook.restapizoobook.domain.*;
import com.api.zoobook.restapizoobook.dto.PetDTO;
import com.api.zoobook.restapizoobook.exceptions.ObjectNotFoundException;
import com.api.zoobook.restapizoobook.repositores.PetRepository;
import com.api.zoobook.restapizoobook.security.UserSS;
import com.api.zoobook.restapizoobook.services.exceptions.AuthorizationException;
import com.api.zoobook.restapizoobook.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository repo;

    @Autowired
    private ClienteService clienteService;


    public Pet find(Integer id) {
        Optional<Pet> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pet.class.getName()));
    }

    public Pet insert(Pet obj) {
        obj.setId(null);
        obj.setData_nascimento(new Date());
        obj.setAceita_relacionamento(true);
        obj.setDoacao(false);
        obj.setFiliacao(null);
        obj.setNome(null);
        obj.setRaça(null);
        obj.setFoto(null);
        obj.setIdade(null);
        obj.setTipo(null);
        obj.setCliente(clienteService.find(obj.getCliente().getId()));
        obj = repo.save(obj);
        return obj;
    }

    public Pet update(Pet obj) {
        Pet newObj = find(obj.getId());
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

    public List<Pet> findAll() {
        return repo.findAll();
    }


    public Pet fromDTO(PetDTO objDto) {
        return new Pet(objDto.getId(), objDto.getNome(), objDto.getRaca(),
                objDto.getIdade(), objDto.getData_nascimento(),
                objDto.getPeso(), objDto.getFiliacao(), null, objDto.isAceita_relacionamento(),
                objDto.isDoacao(), objDto.getFoto(), null);
    }


    public Page<Pet> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        UserSS user = UserService.authenticated();
        if (user == null) {
            throw new AuthorizationException("Acesso negado");
        }
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Cliente cliente =  clienteService.find(user.getId());
        return repo.findByCliente(cliente, pageRequest);
    }

    private void updateData(Pet newObj, Pet obj) {
        newObj.setNome(obj.getNome());
        newObj.setRaça(obj.getRaça());
        newObj.setIdade(obj.getIdade());
        newObj.setData_nascimento(obj.getData_nascimento());
        newObj.setPeso(obj.getPeso());
        newObj.setFiliacao(obj.getFiliacao());
        newObj.setAceita_relacionamento(obj.isAceita_relacionamento());
        newObj.setDoacao(obj.isDoacao());
        newObj.setFoto(obj.getFoto());
        newObj.setTipo(obj.getTipo());
    }
}
