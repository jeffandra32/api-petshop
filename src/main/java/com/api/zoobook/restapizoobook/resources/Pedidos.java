package com.api.zoobook.restapizoobook.resources;


import com.api.zoobook.restapizoobook.domain.servico.Servico;
import com.api.zoobook.restapizoobook.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value="v2/pedidos")
public class Pedidos {

    @Autowired
    private ServicoService service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Servico> find(@PathVariable Integer id) {
        Servico obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Servico obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<Page<Servico>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="instante") String orderBy,
            @RequestParam(value="direction", defaultValue="DESC") String direction) {
        Page<Servico> list = service.findPage(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(list);
    }
}