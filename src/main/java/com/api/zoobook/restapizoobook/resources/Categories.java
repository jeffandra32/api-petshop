package com.api.zoobook.restapizoobook.resources;


import com.api.zoobook.restapizoobook.domain.Categoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "v1/categorias")
public class Categories {

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listar(){

        Categoria c1 = new Categoria(1, "Vira Lata");
        Categoria c2 = new Categoria(1, "PitBull");

        List<Categoria> lista = new ArrayList<>();
        lista.add(c1);
        lista.add(c2);

        return lista;
    }
}
