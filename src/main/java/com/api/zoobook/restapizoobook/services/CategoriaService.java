package com.api.zoobook.restapizoobook.services;

import com.api.zoobook.restapizoobook.domain.Categoria;
import com.api.zoobook.restapizoobook.exceptions.ObjectNotFoundException;
import com.api.zoobook.restapizoobook.repositores.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
            if(obj == null){
                throw new ObjectNotFoundException("Objeto não encontrado ID: " + id
                        + " , Tipo: " + Categoria.class.getName());
            }
        return obj.orElse(null);
    }
}
