package com.api.zoobook.restapizoobook.resources;

import com.api.zoobook.restapizoobook.domain.Localizacao;
import com.api.zoobook.restapizoobook.dto.LocalizacaoDTO;
import com.api.zoobook.restapizoobook.services.LocaizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v2/map")
public class MapsController {

    @Autowired
    private LocaizacaoService service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Localizacao> find(@PathVariable Integer id) {
        Localizacao obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody LocalizacaoDTO objDto) {
        Localizacao obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<LocalizacaoDTO>> findAll() {
        List<Localizacao> list = service.findAll();
        List<LocalizacaoDTO> listDto = list.stream().map(obj -> new LocalizacaoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}

