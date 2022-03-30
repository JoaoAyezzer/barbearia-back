package br.com.mobintech.barbearia.service;

import br.com.mobintech.barbearia.models.Usuario;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendEmail(SimpleMailMessage msg);

    void sendNewPasswordEmail(Usuario usuario, String newPass);

}