package com.api.zoobook.restapizoobook.services;

import com.api.zoobook.restapizoobook.domain.Usuario;
import com.api.zoobook.restapizoobook.repositores.ClienteRepository;
import com.api.zoobook.restapizoobook.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

    private EmailService emailService;

    private Random rand = new Random();

    public void sendNewPassword(String email) {

        Usuario usuario = clienteRepository.findByEmail(email);
        if (usuario == null) {
            throw new ObjectNotFoundException("Email não encontrado");
        }

        String newPass = newPassword();
        usuario.setPassword(pe.encode(newPass));

        clienteRepository.save(usuario);
        emailService.sendNewPasswordEmail(usuario, newPass);
    }

    private String newPassword() {
        char[] vet = new char[10];
        for (int i=0; i<10; i++) {
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    private char randomChar() {
        int opt = rand.nextInt(3);
        if (opt == 0) { // gera um digito
            return (char) (rand.nextInt(10) + 48);
        }
        else if (opt == 1) { // gera letra maiuscula
            return (char) (rand.nextInt(26) + 65);
        }
        else { // gera letra minuscula
            return (char) (rand.nextInt(26) + 97);
        }
    }
}