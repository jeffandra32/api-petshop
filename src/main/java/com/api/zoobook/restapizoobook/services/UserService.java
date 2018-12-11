package com.api.zoobook.restapizoobook.services;

import com.api.zoobook.restapizoobook.domain.User;
import com.api.zoobook.restapizoobook.repositores.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public User buscar(Integer id){
        Optional<User> obj = usuarioRepository.findById(id);
        return obj.orElse(null);
    }
}
