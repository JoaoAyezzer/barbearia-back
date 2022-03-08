package com.tech.barbeariaback.models;

import com.tech.barbeariaback.models.enums.PerfilUsuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String email;
    private String senha;
    private Date dataCadastro;
    private Integer perfilUsuario;
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(Long id, String email, String senha, Date dataCadastro, PerfilUsuario perfilUsuario) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.perfilUsuario = perfilUsuario.getCod();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public PerfilUsuario getPerfilUsuario() {
        return PerfilUsuario.toEnum(this.perfilUsuario);
    }

    public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario.getCod();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", perfilUsuario=" + perfilUsuario +
                ", agendamentos=" + agendamentos +
                '}';
    }
}
