package com.api.zoobook.restapizoobook.services;

import com.api.zoobook.restapizoobook.domain.Usuario;
import com.api.zoobook.restapizoobook.domain.servico.Servico;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendOrderConfirmationEmail(Servico obj) {
        SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Servico obj) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(obj.getUsuario().getEmail());
        sm.setFrom(sender);
        sm.setSubject("Servico confirmado! Código: " + obj.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(obj.toString());
        return sm;
    }

    @Override
    public void sendNewPasswordEmail(Usuario usuario, String newPass) {
        SimpleMailMessage sm = prepareNewPasswordEmail(usuario, newPass);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareNewPasswordEmail(Usuario usuario, String newPass) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(usuario.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Solicitação de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nova senha: " + newPass);
        return sm;
    }
}
