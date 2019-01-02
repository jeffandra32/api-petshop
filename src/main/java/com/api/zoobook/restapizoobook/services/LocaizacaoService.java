package com.api.zoobook.restapizoobook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.api.zoobook.restapizoobook.domain.Localizacao;
import com.api.zoobook.restapizoobook.domain.servico.Categoria;
import com.api.zoobook.restapizoobook.dto.LocalizacaoDTO;
import com.api.zoobook.restapizoobook.exceptions.ObjectNotFoundException;
import com.api.zoobook.restapizoobook.repositores.LocalizacaoRepository;
import com.api.zoobook.restapizoobook.services.exceptions.DataIntegrityException;

@Service
public class LocaizacaoService {

    @Autowired
    private LocalizacaoRepository repo;

    public Localizacao find(Integer id) {
        Optional<Localizacao> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Localizacao> findAll() {
        return repo.findAll();
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma localizacao que possui endereco");
        }
    }

    public Localizacao insert(Localizacao obj) {
        obj.setId(null);
        obj.setLatitude(null);
        obj.setLongitude(null);
        obj = repo.save(obj);
        return obj;
    }

    public Localizacao fromDTO(LocalizacaoDTO objDto) {
        return new Localizacao(objDto.getId(), objDto.getLatitude(), objDto.getLongitude());
    }

}
