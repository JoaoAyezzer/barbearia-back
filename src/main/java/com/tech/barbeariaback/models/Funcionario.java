package com.tech.barbeariaback.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
@Data
@NoArgsConstructor
@Entity(name = "funcionarios")
@JsonTypeName("funcionario")
public class Funcionario extends Usuario{
    private static final long serialVersionUID = 1L;
    @Column
    private Double salario;
    @Column
    private Double consumo;

    public Funcionario(String nome, String email, String senha, Date dataNasc, Date dataCadastro, Integer perfilDeUsuario, String telefone, Double salario, Double consumo) {
        super(nome, email, senha, dataNasc, dataCadastro, perfilDeUsuario, telefone);
        this.salario = salario;
        this.consumo = consumo;
    }

}
