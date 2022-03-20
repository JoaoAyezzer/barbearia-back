package com.tech.barbeariaback.service;

import com.tech.barbeariaback.dto.FuncionarioDTO;
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
public class FuncionarioService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<Usuario> findAll(){
        List<Usuario> admins = repository.findAllByPerfilDeUsuario(PerfilUsuario.ADMIN.getCod());
        List<Usuario> funcionarios = repository.findAllByPerfilDeUsuario(PerfilUsuario.FUNCIONARIO.getCod());
        funcionarios.addAll(admins);
        return funcionarios;
    }
    public Usuario findById(Long id){
        UserSpringSecurity user = UserService.authenticated();
        if (user == null || !user.hasRole(PerfilUsuario.ADMIN) && !id.equals(user.getId())){
            throw  new AuthorizationException("Voce esta tentando acessar um funcionario o qual voce nao tem permissão");
        }
        Optional<Usuario> funcionario = repository.findById(id);
        return funcionario.orElseThrow(()-> new ObjectNotfoundException(
                "Objeto nao encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()
        ));
    }
    public Funcionario update(Long id, Funcionario funcionario){
        findById(id);
        funcionario.setId(id);
        return repository.save(funcionario);
    }
    public Funcionario insert(Funcionario funcionario){
        return repository.save(funcionario);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    public Funcionario fromDTO(FuncionarioDTO funcionarioDTO){
        Date dataCadastro = new Date();
        return new Funcionario(
                funcionarioDTO.getNome(),
                funcionarioDTO.getEmail(),
                passwordEncoder.encode(funcionarioDTO.getSenha()),
                funcionarioDTO.getDataNasc(),
                dataCadastro,
                PerfilUsuario.FUNCIONARIO.getCod(),
                funcionarioDTO.getTelefone(),
                funcionarioDTO.getSalario(),
                funcionarioDTO.getConsumo());
    }


}
