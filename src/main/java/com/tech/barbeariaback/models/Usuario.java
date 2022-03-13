package com.tech.barbeariaback.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.tech.barbeariaback.models.enums.PerfilUsuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String senha;
    @Column
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date dataNasc;
    @Column
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date dataCadastro;
    @Column
    private Integer perfilDeUsuario;
    @ElementCollection
    @CollectionTable(name = "TELEFONES")
    private Set<Integer> telefones = new HashSet<>();




    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String senha, Date dataNasc, Date dataCadastro, PerfilUsuario perfilDeUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.dataCadastro = dataCadastro;
        this.perfilDeUsuario = perfilDeUsuario.getCod();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public PerfilUsuario getPerfilDeUsuario() {
        return PerfilUsuario.toEnum(this.perfilDeUsuario);
    }

    public void setPerfilDeUsuario(PerfilUsuario perfilDeUsuario) {
        this.perfilDeUsuario = perfilDeUsuario.getCod();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", dataNasc=" + dataNasc +
                ", dataCadastro=" + dataCadastro +
                ", perfilDeUsuario=" + perfilDeUsuario +
                '}';
    }
}
