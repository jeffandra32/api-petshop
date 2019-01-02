package com.api.zoobook.restapizoobook.resources;


import com.api.zoobook.restapizoobook.domain.pet.Pet;
import com.api.zoobook.restapizoobook.dto.PetDTO;
import com.api.zoobook.restapizoobook.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "v2/pets")
public class Pets {

    @Autowired
    private PetService service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Pet> find(@PathVariable Integer id) {
        Pet obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Pet obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }



    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody PetDTO objDto, @PathVariable Integer id) {
        Pet obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ResponseEntity<List<PetDTO>> findAll() {
        List<Pet> list = service.findAll();
        List<PetDTO> listDto = list.stream().map(obj -> new PetDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<Page<Pet>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="instante") String orderBy,
            @RequestParam(value="direction", defaultValue="DESC") String direction) {
        Page<Pet> list = service.findPage(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value="/photo", method=RequestMethod.POST)
    public ResponseEntity<Void> uploadProfilePicture(@RequestParam(name="file") MultipartFile file) {
        URI uri = service.uploadProfilePicture(file);
        return ResponseEntity.created(uri).build();
    }
}
