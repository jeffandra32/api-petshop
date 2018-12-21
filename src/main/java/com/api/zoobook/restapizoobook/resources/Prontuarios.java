package com.api.zoobook.restapizoobook.resources;


import com.api.zoobook.restapizoobook.domain.Cliente;
import com.api.zoobook.restapizoobook.domain.Prontuario;
import com.api.zoobook.restapizoobook.domain.socialNetwork.*;
import com.api.zoobook.restapizoobook.dto.*;
import com.api.zoobook.restapizoobook.services.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "v2/prontuario")
public class Prontuarios {

    @Autowired
    private ProntuarioService service;


    /** ENDPOINT PARA POSTAGENS START*/

    @RequestMapping(value="/find/{id}", method=RequestMethod.GET)
    public ResponseEntity<Prontuario> find(@PathVariable Integer id) {
        Prontuario obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Prontuario obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ProntuarioDTO objDto, @PathVariable Integer id) {
        Prontuario obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ResponseEntity<List<ProntuarioDTO>> findAll() {
        List<Prontuario> list = service.findAll();
        List<ProntuarioDTO> listDto = list.stream().map(obj -> new ProntuarioDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }




}
