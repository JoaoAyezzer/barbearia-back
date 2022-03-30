package br.com.mobintech.barbearia.dto;

import br.com.mobintech.barbearia.models.Cliente;
import br.com.mobintech.barbearia.models.enums.PerfilUsuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ClienteDTO implements Serializable {
    private Long id;
    @NotEmpty(message = "Nome é obrigatório")
    private  String nome;
    @Email
    @NotEmpty(message = "Email não pode ser vazio")
    private  String email;
    @NotEmpty(message = "Senha não pode ser vazia")
    private  String senha;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private LocalDate dataNasc;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private  LocalDate dataCadastro;
    private  Integer perfilDeUsuario;
    private  String telefone;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.senha = cliente.getSenha();
        this.dataNasc = cliente.getDataNasc();
        this.dataCadastro = cliente.getDataCadastro();
        this.perfilDeUsuario = cliente.getPerfilDeUsuario().getCod();
        this.telefone = cliente.getTelefone();
    }
    public PerfilUsuario getPerfilDeUsuario() {
        return PerfilUsuario.toEnum(this.perfilDeUsuario);
    }
}
