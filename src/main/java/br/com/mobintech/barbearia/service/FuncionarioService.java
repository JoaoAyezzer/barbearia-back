package br.com.mobintech.barbearia.service;

import br.com.mobintech.barbearia.models.Usuario;
import br.com.mobintech.barbearia.dto.FuncionarioDTO;
import br.com.mobintech.barbearia.models.Funcionario;
import br.com.mobintech.barbearia.models.enums.PerfilUsuario;
import br.com.mobintech.barbearia.repositories.UsuarioRepository;
import br.com.mobintech.barbearia.security.UserSpringSecurity;
import br.com.mobintech.barbearia.service.exceptions.AuthorizationException;
import br.com.mobintech.barbearia.service.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Funcionario create(FuncionarioDTO funcionarioDTO){
        return repository.save(fromDTO(funcionarioDTO));
    }

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
        return funcionario.orElseThrow(
                ()-> new ObjectNotfoundException(
                    "Funcionario com Id: " + id + ", não encontrado na base de dados"
                )
        );
    }
    public void update(Long id, FuncionarioDTO funcionarioDTO){
        findById(id);
        funcionarioDTO.setId(id);
        repository.save(fromDTO(funcionarioDTO));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    public Funcionario fromDTO(FuncionarioDTO funcionarioDTO){
        LocalDate dataCadastro = LocalDate.now();
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
