package com.tech.barbeariaback.service;

import com.tech.barbeariaback.models.Usuario;
import com.tech.barbeariaback.repositories.UsuarioRepository;
import com.tech.barbeariaback.service.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    private Random random = new Random();

    public void sendNewPassword(String email){
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null){
            throw new ObjectNotfoundException("Email não encontrado na base de dados");

        }
        String newPass = newPassword();
        usuario.setSenha(passwordEncoder.encode(newPass));

        usuarioRepository.save(usuario);
        emailService.sendNewPasswordEmail(usuario, newPass);

    }

    private String newPassword() {
        char[] vet = new char[10];
        for (int i=0; i<10; i++){
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    private char randomChar() {
        int opt = random.nextInt(3);
        if (opt == 0){
            return (char) (random.nextInt(10) + 48);
        }
        else if (opt == 1){
            return (char) (random.nextInt(26) + 65);
        }
        else{
            return (char) (random.nextInt(26) + 97);
        }
    }

}