package com.tech.barbeariaback.service;

import com.tech.barbeariaback.dto.BarbeiroDTO;
import com.tech.barbeariaback.models.Barbeiro;
import com.tech.barbeariaback.models.Usuario;
import com.tech.barbeariaback.models.enums.PerfilUsuario;
import com.tech.barbeariaback.repositories.UsuarioRepository;
import com.tech.barbeariaback.security.UserSpringSecurity;
import com.tech.barbeariaback.service.exceptions.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BarbeiroService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private FuncionarioService funcionarioService;

    public List<Usuario> findAll(){
        return repository.findAllByPerfilDeUsuario(PerfilUsuario.BARBEIRO.getCod());
    }

    public Barbeiro insert(Barbeiro barbeiro){
        return repository.save(barbeiro);
    }

    public Barbeiro update(Long id, Barbeiro barbeiro){
        funcionarioService.findById(id);
        barbeiro.setId(id);
        return repository.save(barbeiro);
    }
    public void delete(Long id) {
        funcionarioService.findById(id);
        repository.deleteById(id);
    }

    public Barbeiro fromDTO(BarbeiroDTO barbeiroDTO){
        Date dataCadastro = (barbeiroDTO.getDataCadastro() == null) ? new Date() : barbeiroDTO.getDataCadastro();
        return new Barbeiro(
                barbeiroDTO.getNome(),
                barbeiroDTO.getEmail(),
                passwordEncoder.encode(barbeiroDTO.getSenha()),
                barbeiroDTO.getDataNasc(),
                dataCadastro,
                barbeiroDTO.getPerfilDeUsuario().getCod(),
                barbeiroDTO.getTelefone(),
                barbeiroDTO.getPercentualComissao(),
                barbeiroDTO.getDataInicialComissao(),
                barbeiroDTO.getDataFinalComissao()
        );
    }


}
