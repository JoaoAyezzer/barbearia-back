package com.tech.barbeariaback.service;

import com.tech.barbeariaback.dto.FuncionarioDTO;
import com.tech.barbeariaback.models.Funcionario;
import com.tech.barbeariaback.models.Usuario;
import com.tech.barbeariaback.models.enums.PerfilUsuario;
import com.tech.barbeariaback.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<Usuario> findAll(){
        return repository.findAllByPerfilDeUsuario(PerfilUsuario.ADMIN.getCod());
    }

    public Funcionario insert(Funcionario funcionario){
        return repository.save(funcionario);
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
