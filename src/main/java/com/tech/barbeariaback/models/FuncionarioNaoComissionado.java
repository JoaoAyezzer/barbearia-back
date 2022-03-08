package com.tech.barbeariaback.models;

import com.tech.barbeariaback.models.enums.PerfilUsuario;

import java.util.Date;

public class FuncionarioNaoComissionado extends Funcionario{
    private static final long serialVersionUID = 1L;

    private Double salario;
    private Date dataPagamento;

    public FuncionarioNaoComissionado(){

    }
    public FuncionarioNaoComissionado(Long id, String nome, String email, String senha, Date dataNasc, Date dataCadastro, PerfilUsuario perfilDeUsuario, Double salario, Date dataPagamento) {
        super(id, nome, email, senha, dataNasc, dataCadastro, perfilDeUsuario);
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
