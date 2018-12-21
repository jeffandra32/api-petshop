package com.api.zoobook.restapizoobook.resources;

import com.api.zoobook.restapizoobook.domain.Cliente;
import com.api.zoobook.restapizoobook.dto.ClienteDTO;
import com.api.zoobook.restapizoobook.dto.ClienteNewDTO;
import com.api.zoobook.restapizoobook.dto.EmailDTO;
import com.api.zoobook.restapizoobook.security.JWTUtil;
import com.api.zoobook.restapizoobook.security.UserSS;
import com.api.zoobook.restapizoobook.services.AuthService;
import com.api.zoobook.restapizoobook.services.ClienteService;
import com.api.zoobook.restapizoobook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/login")
public class Auth {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService service;

    @Autowired
    private ClienteService service2;



    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insertLogin(@Valid @RequestBody ClienteDTO objDto, @PathVariable Integer id) {
        Cliente obj = service2.fromDTO(objDto);
        obj = service2.insert(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/Register", method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO objDto) {
        Cliente obj = service2.fromDTO(objDto);
        obj = service2.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserSS user = UserService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers", "Authorization");
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDto) {
        service.sendNewPassword(objDto.getEmail());
        return ResponseEntity.noContent().build();
    }


}