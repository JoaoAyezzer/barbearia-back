package com.tech.barbeariaback.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.tech.barbeariaback.models.enums.PerfilUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy= InheritanceType.JOINED)
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    @JsonIgnore
    private String senha;
    @Column
    @JsonFormat(pattern="dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private Date dataNasc;
    @Column
    @JsonFormat(pattern="dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private Date dataCadastro;
    @Column
    private Integer perfilDeUsuario;
    @Column
    private String telefone;
    @Column
    private String urlAvatar;

    public PerfilUsuario getPerfilDeUsuario() {
        return PerfilUsuario.toEnum(this.perfilDeUsuario);
    }
    public void setPerfilDeUsuario(PerfilUsuario perfilDeUsuario) {
        this.perfilDeUsuario = perfilDeUsuario.getCod();
    }

    public Usuario(String nome, String email, String senha, Date dataNasc, Date dataCadastro, Integer perfilDeUsuario, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.dataCadastro = dataCadastro;
        this.perfilDeUsuario = perfilDeUsuario;
        this.telefone = telefone;
    }

}
