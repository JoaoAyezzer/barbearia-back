package com.tech.barbeariaback.service;

import com.tech.barbeariaback.models.Usuario;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendEmail(SimpleMailMessage msg);

    void sendNewPasswordEmail(Usuario usuario, String newPass);

}