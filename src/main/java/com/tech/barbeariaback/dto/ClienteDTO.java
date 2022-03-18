package com.tech.barbeariaback.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tech.barbeariaback.models.Cliente;
import com.tech.barbeariaback.models.enums.PerfilUsuario;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private  Date dataNasc;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private  Date dataCadastro;
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
