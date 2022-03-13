package com.tech.barbeariaback.models;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Double valorBruto;
    @Column
    private Double valorLiquido;
    @Column
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date dataRecebimento;
    @ManyToOne
    @JoinColumn(name = "tipo_pagamento_id")
    private TipoPagamento tipoPagamento;

    public Pagamento() {
    }

    public Pagamento(Long id, Double valorBruto, Double valorLiquido, Date dataRecebimento, TipoPagamento tipoPagamento) {
        this.id = id;
        this.valorBruto = valorBruto;
        this.valorLiquido = valorLiquido;
        this.dataRecebimento = dataRecebimento;
        this.tipoPagamento = tipoPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(Double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public Double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(Double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return id.equals(pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", valorBruto=" + valorBruto +
                ", valorLiquido=" + valorLiquido +
                ", dataRecebimento=" + dataRecebimento +
                ", tipoPagamento=" + tipoPagamento +
                '}';
    }
}
