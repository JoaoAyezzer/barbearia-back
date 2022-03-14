package com.tech.barbeariaback.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.tech.barbeariaback.models.enums.PerfilUsuario;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@JsonTypeName("CLIENTE")
public class Cliente extends Usuario {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "cliente")
    private List<Agendamento> agendamentos = new ArrayList<>();


    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, String senha, Date dataNasc, Date dataCadastro, PerfilUsuario perfilDeUsuario, String telefone) {
        super(id, nome, email, senha, dataNasc, dataCadastro, perfilDeUsuario, telefone);
    }
    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
