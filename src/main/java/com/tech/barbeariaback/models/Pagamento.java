package com.tech.barbeariaback.models;

import com.sun.jdi.DoubleValue;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Double valorBruto;
    private Double valorLiquido;
    private Date dataRecebimento;
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
