package com.tech.barbeariaback.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TipoPagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Float taxaRecebimento;
    private Date prazoRecebimento;

    public TipoPagamento() {
    }

    public TipoPagamento(Long id, String nome, Float taxaRecebimento, Date prazoRecebimento) {
        this.id = id;
        this.nome = nome;
        this.taxaRecebimento = taxaRecebimento;
        this.prazoRecebimento = prazoRecebimento;
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

    public Float getTaxaRecebimento() {
        return taxaRecebimento;
    }

    public void setTaxaRecebimento(Float taxaRecebimento) {
        this.taxaRecebimento = taxaRecebimento;
    }

    public Date getPrazoRecebimento() {
        return prazoRecebimento;
    }

    public void setPrazoRecebimento(Date prazoRecebimento) {
        this.prazoRecebimento = prazoRecebimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoPagamento that = (TipoPagamento) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TipoPagamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", taxaRecebimento=" + taxaRecebimento +
                ", prazoRecebimento=" + prazoRecebimento +
                '}';
    }
}
