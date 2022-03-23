package com.tech.barbeariaback.service;

import com.tech.barbeariaback.dto.ClienteDTO;
import com.tech.barbeariaback.models.Cliente;
import com.tech.barbeariaback.models.Funcionario;
import com.tech.barbeariaback.models.Usuario;
import com.tech.barbeariaback.models.enums.PerfilUsuario;
import com.tech.barbeariaback.repositories.UsuarioRepository;
import com.tech.barbeariaback.security.UserSpringSecurity;
import com.tech.barbeariaback.service.exceptions.AuthorizationException;
import com.tech.barbeariaback.service.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<Usuario> findAll(){
        return repository.findAllByPerfilDeUsuario(PerfilUsuario.CLIENTE.getCod());
    }
    public Usuario findById(Long id) {
        UserSpringSecurity user = UserService.authenticated();
        if (user == null || !user.hasRole(PerfilUsuario.ADMIN) && !id.equals(user.getId())){
            throw  new AuthorizationException("Voce esta tentando acessar um funcionario o qual voce nao tem permissão");
        }
        Optional<Usuario> cliente = repository.findById(id);
        return cliente.orElseThrow(()-> new ObjectNotfoundException(
                "Objeto nao encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()
        ));
    }
    public void update(Long id, ClienteDTO clienteDTO){
        findById(id);
        repository.save(fromDTO(clienteDTO));
    }
    public Cliente insert(ClienteDTO clienteDTO){
        return repository.save(fromDTO(clienteDTO));
    }
    public void delete(Long id){
        findById(id);
        repository.deleteById(id);
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
