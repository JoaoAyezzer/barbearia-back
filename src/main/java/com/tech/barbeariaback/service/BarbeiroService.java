package com.tech.barbeariaback.service;

import com.tech.barbeariaback.dto.BarbeiroDTO;
import com.tech.barbeariaback.models.Barbeiro;
import com.tech.barbeariaback.models.Usuario;
import com.tech.barbeariaback.models.enums.PerfilUsuario;
import com.tech.barbeariaback.repositories.UsuarioRepository;
import com.tech.barbeariaback.service.exceptions.DataIntegrityException;
import com.tech.barbeariaback.service.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public Barbeiro findById(Long id){
        try{
            return ( Barbeiro ) repository.findById(id).get();
        }catch (ObjectNotfoundException e){
            throw new ObjectNotfoundException("Barbeiro não encontrado");
        }
    }
    public Barbeiro create(BarbeiroDTO barbeiroDTO){
        try{
            return repository.save(fromDTO(barbeiroDTO));
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Já existe um usuário com esse email");
        }
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
        LocalDate dataCadastro = (barbeiroDTO.getDataCadastro() == null) ? LocalDate.now() : barbeiroDTO.getDataCadastro();
        return new Barbeiro(
                barbeiroDTO.getNome(),
                barbeiroDTO.getEmail(),
                passwordEncoder.encode(barbeiroDTO.getSenha()),
                barbeiroDTO.getDataNasc(),
                dataCadastro,
                PerfilUsuario.BARBEIRO.getCod(),
                barbeiroDTO.getTelefone(),
                barbeiroDTO.getPercentualComissao(),
                barbeiroDTO.getDataInicialComissao(),
                barbeiroDTO.getDataFinalComissao()
        );
    }


}
