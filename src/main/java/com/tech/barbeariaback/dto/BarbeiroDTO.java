package com.tech.barbeariaback.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tech.barbeariaback.models.Barbeiro;
import com.tech.barbeariaback.models.enums.PerfilUsuario;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


@Data
@NoArgsConstructor
public class BarbeiroDTO {
    private Long id;
    @NotEmpty(message = "Nome é obrigatório")
    private String nome;
    @NotEmpty(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;
    @NotEmpty(message = "Senha é obrigatório")
    private String senha;
    @NotEmpty(message = "Telefone é obrigatório")
    private String telefone;
    private String urlAvatar;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private LocalDate dataNasc;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private LocalDate dataCadastro;
    private Integer perfilDeUsuario;
    private Integer percentualComissao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicialComissao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFinalComissao;


    public BarbeiroDTO(Barbeiro barbeiro) {
        this.nome = barbeiro.getNome();
        this.email = barbeiro.getEmail();
        this.senha = barbeiro.getSenha();
        this.telefone = barbeiro.getTelefone();
        this.urlAvatar = barbeiro.getUrlAvatar();
        this.dataNasc = barbeiro.getDataNasc();
        this.perfilDeUsuario = barbeiro.getPerfilDeUsuario().getCod();
        this.percentualComissao = barbeiro.getPercentualComissao();
        this.dataInicialComissao = barbeiro.getDataInicialComissao();
        this.dataFinalComissao = barbeiro.getDataFinalComissao();
    }

    public PerfilUsuario getPerfilDeUsuario() {
        return PerfilUsuario.toEnum(perfilDeUsuario);
    }
}
