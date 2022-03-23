package com.tech.barbeariaback.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@Entity(name = "clientes")
public class Cliente extends Usuario {
    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "cliente")
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Cliente(String nome, String email, String senha, Date dataNasc, Date dataCadastro, Integer perfilDeUsuario, String telefone) {
        super(nome, email, senha, dataNasc, dataCadastro, perfilDeUsuario, telefone);
    }
}
