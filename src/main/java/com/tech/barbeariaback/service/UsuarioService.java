package com.tech.barbeariaback.service;

import com.tech.barbeariaback.models.Usuario;
import com.tech.barbeariaback.models.enums.PerfilUsuario;
import com.tech.barbeariaback.repositories.UsuarioRepository;
import com.tech.barbeariaback.service.exceptions.DataIntegrityException;
import com.tech.barbeariaback.service.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public List<Usuario> findAllByPerfil(String perfilUsuario) {
        Integer perfil = 0;
        if (perfilUsuario.equalsIgnoreCase("clientes")){
            perfil = PerfilUsuario.CLIENTE.getCod();
        }else if (perfilUsuario.equalsIgnoreCase("funcionarios")){
            perfil = PerfilUsuario.FUNCIONARIO.getCod();
        }else{
            throw new DataIntegrityException( "Url invalida, Verifique e tente novamente ");
        }
        return repository.findAllByPerfilDeUsuario(perfil);
    }
    public Optional<Usuario> findById(Long id){
        Optional<Usuario> usuario = repository.findById(id);
        return Optional.ofNullable(usuario.orElseThrow(() -> new ObjectNotfoundException("Objeto nao encontrado! Id: " + id)));
    }

}
