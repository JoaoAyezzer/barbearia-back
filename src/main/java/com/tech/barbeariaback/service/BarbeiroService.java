package com.tech.barbeariaback.service;

import com.tech.barbeariaback.dto.BarbeiroDTO;
import com.tech.barbeariaback.models.Barbeiro;
import com.tech.barbeariaback.models.Usuario;
import com.tech.barbeariaback.models.enums.PerfilUsuario;
import com.tech.barbeariaback.repositories.UsuarioRepository;
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

    public Barbeiro insert(BarbeiroDTO barbeiroDTO){
        return repository.save(fromDTO(barbeiroDTO));
    }

    public void update(Long id, BarbeiroDTO barbeiroDTO){
        funcionarioService.findById(id);
        barbeiroDTO.setId(id);
        repository.save(fromDTO(barbeiroDTO));
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
