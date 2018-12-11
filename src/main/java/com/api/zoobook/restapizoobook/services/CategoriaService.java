package com.api.zoobook.restapizoobook.services;

import com.api.zoobook.restapizoobook.domain.Categoria;
import com.api.zoobook.restapizoobook.dto.CategoriaDTO;
import com.api.zoobook.restapizoobook.exceptions.ObjectNotFoundException;
import com.api.zoobook.restapizoobook.repositores.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    /** Metodo GET ID*/
    public Categoria find(Integer id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
            if(obj == null){
                throw new ObjectNotFoundException("Objeto não encontrado ID: " + id
                        + " , Tipo: " + Categoria.class.getName());
            }
        return obj.orElse(null);
    }

    /** Metodo GET ALL*/
    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    /** Metodo POST */
    public  Categoria insert(Categoria obj){
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    /** Metodo UPDATE */
    public  Categoria update(Categoria obj){
        find(obj.getId());
        return categoriaRepository.save(obj);
    }

    /** Metodo DELETE */
    public  void delete(Integer id){
        find(id);
        try {
            categoriaRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possível excluir uma categoria que ainda possui produtos");
        }
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction),orderBy);
        return categoriaRepository.findAll(pageRequest);
    }

    public Categoria fromDTO(CategoriaDTO objDto){
        return new Categoria(objDto.getId(), objDto.getNome());
    }
}
