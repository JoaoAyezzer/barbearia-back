package com.tech.barbeariaback.service;

import com.tech.barbeariaback.dto.ClienteDTO;
import com.tech.barbeariaback.models.Cliente;
import com.tech.barbeariaback.models.Usuario;
import com.tech.barbeariaback.models.enums.PerfilUsuario;
import com.tech.barbeariaback.repositories.UsuarioRepository;
import com.tech.barbeariaback.service.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public Cliente findById(Long id) {
        return (Cliente) repository.findById(id).orElseThrow(
                () ->  new ObjectNotfoundException( "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName() )
        );
    }
    public void update(Long id, ClienteDTO clienteDTO){
        findById(id);
        repository.save(fromDTO(clienteDTO));
    }
    public Cliente create(ClienteDTO clienteDTO){
        return repository.save(fromDTO(clienteDTO));
    }
    public void delete(Long id){
        findById(id);
        repository.deleteById(id);
    }

    public Cliente fromDTO(ClienteDTO clienteDto){
        LocalDate dataCadastro = LocalDate.now();
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
