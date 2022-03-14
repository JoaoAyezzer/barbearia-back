package com.tech.barbeariaback.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.tech.barbeariaback.models.enums.PerfilUsuario;

import javax.persistence.Entity;
import java.util.Date;
@Entity
@JsonTypeName("FUNCIONARIO")
public class Funcionario extends Usuario{
    private static final long serialVersionUID = 1L;

    private Double salario;
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date dataPagamento;

    public Funcionario(){

    }
    public Funcionario(Long id, String nome, String email, String senha, Date dataNasc, Date dataCadastro, PerfilUsuario perfilDeUsuario, Double salario, Date dataPagamento, String telefone) {
        super(id, nome, email, senha, dataNasc, dataCadastro, perfilDeUsuario, telefone);
        this.salario = salario;
        this.dataPagamento = dataPagamento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
