package com.api.zoobook.restapizoobook.services;

import com.api.zoobook.restapizoobook.domain.Usuario;
import com.api.zoobook.restapizoobook.domain.servico.Servico;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Servico obj);

    void sendEmail(SimpleMailMessage msg);

    void sendNewPasswordEmail(Usuario usuario, String newPass);
}