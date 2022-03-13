package com.tech.barbeariaback.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.jdi.DoubleValue;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String descricao;
    @Column
    private Double precoDeCompra;
    @Column
    private Double precoDeVenda;
    @Column
    private String codBar;
    @Column
    private Integer QtdEmEstoque;
    @Column
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date dataCadastro;
    @Column
    private String marca;
    @ManyToOne
    @JoinColumn(name = "FORNECEDOR_ID")
    private Fornecedor fornecedor;
    @ManyToMany(mappedBy="produtos")
    private List<Agendamento> agendamentos;

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
