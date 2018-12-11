package com.api.zoobook.restapizoobook.resources;


import com.api.zoobook.restapizoobook.domain.User;
import com.api.zoobook.restapizoobook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "v1/users")
public class Users {

    @Autowired
    private UserService service;

    @RequestMapping(value = "{/id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){
        User obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }
}
