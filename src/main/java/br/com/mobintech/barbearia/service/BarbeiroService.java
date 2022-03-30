package br.com.mobintech.barbearia.service;

import br.com.mobintech.barbearia.models.Usuario;
import br.com.mobintech.barbearia.models.enums.PerfilUsuario;
import br.com.mobintech.barbearia.repositories.UsuarioRepository;
import br.com.mobintech.barbearia.service.exceptions.DataIntegrityException;
import br.com.mobintech.barbearia.service.exceptions.ObjectNotfoundException;
import br.com.mobintech.barbearia.dto.BarbeiroDTO;
import br.com.mobintech.barbearia.models.Barbeiro;
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
        return ( Barbeiro ) repository.findById(id).orElseThrow(
                () -> new ObjectNotfoundException(
                        "Barbeiro com Id: " + id + ", não encontrado na base de dados"
                )
        );
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
