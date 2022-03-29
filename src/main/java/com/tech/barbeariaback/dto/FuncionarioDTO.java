package com.tech.barbeariaback.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tech.barbeariaback.models.Funcionario;
import com.tech.barbeariaback.models.enums.PerfilUsuario;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class FuncionarioDTO {

    private Long id;
    private String nome;
    @Column(unique = true)
    @Email
    @NotEmpty(message = "Email é obrigatório")
    private String email;
    @NotEmpty(message = "Senha é obrigatório")
    private String senha;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private LocalDate dataNasc;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private LocalDate dataCadastro;
    private Integer perfilDeUsuario;
    private String telefone;
    private Double salario;
    private Double consumo;


    public PerfilUsuario getPerfilDeUsuario() {
        return PerfilUsuario.toEnum(this.perfilDeUsuario);
    }

    public FuncionarioDTO(Funcionario funcionario){
        this.nome = funcionario.getNome();
        this.email = funcionario.getEmail();
        this.senha = funcionario.getSenha();
        this.dataNasc = funcionario.getDataNasc();
        this.dataCadastro = funcionario.getDataCadastro();
        this.perfilDeUsuario = funcionario.getPerfilDeUsuario().getCod();
        this.telefone = funcionario.getTelefone();
        this.salario = funcionario.getSalario();
    }
}
