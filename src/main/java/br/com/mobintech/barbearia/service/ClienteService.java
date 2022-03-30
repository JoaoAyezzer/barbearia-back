package br.com.mobintech.barbearia.service;

import br.com.mobintech.barbearia.models.Cliente;
import br.com.mobintech.barbearia.models.Usuario;
import br.com.mobintech.barbearia.models.enums.PerfilUsuario;
import br.com.mobintech.barbearia.repositories.UsuarioRepository;
import br.com.mobintech.barbearia.service.exceptions.ObjectNotfoundException;
import br.com.mobintech.barbearia.dto.ClienteDTO;
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
                () ->  new ObjectNotfoundException(
                        "Cliente com Id: " + id + ", não encontrado na base de dados"
                )
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
