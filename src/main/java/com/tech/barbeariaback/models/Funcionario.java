package com.tech.barbeariaback.models;

import com.tech.barbeariaback.models.enums.DiasDaSemana;
import com.tech.barbeariaback.models.enums.PerfilUsuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Date dataNasc;
    private Date dataCadastro;
    private Integer perfilDeUsuario;
    private List<Integer> diasDeTrabalho = new ArrayList<>();
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String email, String senha, Date dataNasc, Date dataCadastro, PerfilUsuario perfilDeUsuario) {
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

    public List<DiasDaSemana> getDiasDeTrabalho() {
        List<DiasDaSemana> listDiasDeTrabalho = new ArrayList<>();
        this.diasDeTrabalho.stream().forEach(dia -> listDiasDeTrabalho.add(DiasDaSemana.toEnum(dia)));
        return listDiasDeTrabalho;
    }

    public void setDiasDeTrabalho(List<DiasDaSemana> diasDeTrabalho) {
        diasDeTrabalho.stream().forEach(dia -> this.diasDeTrabalho.add(dia.getCod()));
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", dataNasc=" + dataNasc +
                ", dataCadastro=" + dataCadastro +
                ", perfilDeUsuario=" + perfilDeUsuario +
                ", diasDeTrabalho=" + getDiasDeTrabalho() +
                ", agendamentos=" + agendamentos +
                '}';
    }
}
