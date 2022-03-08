package com.tech.barbeariaback.models;

import com.sun.jdi.DoubleValue;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String descricao;
    private Double precoDeCompra;
    private Double precoDeVenda;
    private String codBar;
    private Integer QtdEmEstoque;
    private Date dataCadastro;
    private String marca;
    private Fornecedor fornecedor;

    public Produto() {
    }

    public Produto(Long id, String descricao, Double precoDeCompra, Double precoDeVenda, String codBar, Integer qtdEmEstoque, Date dataCadastro, String marca, Fornecedor fornecedor) {
        this.id = id;
        this.descricao = descricao;
        this.precoDeCompra = precoDeCompra;
        this.precoDeVenda = precoDeVenda;
        this.codBar = codBar;
        QtdEmEstoque = qtdEmEstoque;
        this.dataCadastro = dataCadastro;
        this.marca = marca;
        this.fornecedor = fornecedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoDeCompra() {
        return precoDeCompra;
    }

    public void setPrecoDeCompra(Double precoDeCompra) {
        this.precoDeCompra = precoDeCompra;
    }

    public Double getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void setPrecoDeVenda(Double precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public String getCodBar() {
        return codBar;
    }

    public void setCodBar(String codBar) {
        this.codBar = codBar;
    }

    public Integer getQtdEmEstoque() {
        return QtdEmEstoque;
    }

    public void setQtdEmEstoque(Integer qtdEmEstoque) {
        QtdEmEstoque = qtdEmEstoque;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", precoDeCompra=" + precoDeCompra +
                ", precoDeVenda=" + precoDeVenda +
                ", codBar='" + codBar + '\'' +
                ", QtdEmEstoque=" + QtdEmEstoque +
                ", dataCadastro=" + dataCadastro +
                ", marca='" + marca + '\'' +
                ", fornecedor=" + fornecedor +
                '}';
    }
}
