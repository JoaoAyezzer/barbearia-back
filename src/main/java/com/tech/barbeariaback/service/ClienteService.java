package com.tech.barbeariaback.service;

import com.tech.barbeariaback.dto.ClienteDTO;
import com.tech.barbeariaback.models.Cliente;
import com.tech.barbeariaback.models.Usuario;
import com.tech.barbeariaback.models.enums.PerfilUsuario;
import com.tech.barbeariaback.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<Usuario> findAll(){
        return repository.findAllByPerfilDeUsuario(PerfilUsuario.CLIENTE.getCod());
    }

    public Cliente insert(Cliente cliente){
        return repository.save(cliente);
    }

    public Cliente fromDTO(ClienteDTO clienteDto){
        Date dataCadastro = new Date();
        return new Cliente(
                clienteDto.getNome(),
                clienteDto.getEmail(),
                passwordEncoder.encode(clienteDto.getSenha()),
                clienteDto.getDataNasc(),
                dataCadastro,
                PerfilUsuario.CLIENTE.getCod(),
                clienteDto.getTelefone());
    }

}
