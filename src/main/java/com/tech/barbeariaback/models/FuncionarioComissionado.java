package com.tech.barbeariaback.models;

import com.tech.barbeariaback.models.enums.PerfilUsuario;

import java.util.Date;

public class FuncionarioComissionado extends Funcionario {
    private static final long serialVersionUID = 1L;

    private Float percentualComissao;
    private Date dataInicialComissao;
    private Date dataFinalComissao;
    private Double valorReceber;

    public FuncionarioComissionado() {

    }


    public FuncionarioComissionado(Long id, String nome, String email, String senha, Date dataNasc, Date dataCadastro, PerfilUsuario perfilDeUsuario, Float percentualComissao, Date dataInicialComissao, Date dataFinalComissao, Double valorReceber) {
        super(id, nome, email, senha, dataNasc, dataCadastro, perfilDeUsuario);
        this.percentualComissao = percentualComissao;
        this.dataInicialComissao = dataInicialComissao;
        this.dataFinalComissao = dataFinalComissao;
        this.valorReceber = valorReceber;
    }

    public Float getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(Float percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public Date getDataInicialComissao() {
        return dataInicialComissao;
    }

    public void setDataInicialComissao(Date dataInicialComissao) {
        this.dataInicialComissao = dataInicialComissao;
    }

    public Date getDataFinalComissao() {
        return dataFinalComissao;
    }

    public void setDataFinalComissao(Date dataFinalComissao) {
        this.dataFinalComissao = dataFinalComissao;
    }

    public Double getValorReceber() {
        return valorReceber;
    }

    public void setValorReceber(Double valorReceber) {
        this.valorReceber = valorReceber;
    }
}
