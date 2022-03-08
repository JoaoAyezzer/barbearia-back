package com.tech.barbeariaback.models;

import com.tech.barbeariaback.models.enums.StatusAgendamento;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Date dataInicial;
    private Date dataFinal;
    private Cliente cliente;
    private Integer statusAgendamento;
    private Servico servico;
    private Pagamento pagamento;
    private Double valor;
    private List<Produto> produtos;

    public Agendamento() {
    }

    public Agendamento(Long id, Date dataInicial, Date dataFinal, Cliente cliente, StatusAgendamento statusAgendamento, Servico servico, Pagamento pagamento, Double valor) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cliente = cliente;
        this.statusAgendamento = statusAgendamento.getCod();
        this.servico = servico;
        this.pagamento = pagamento;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusAgendamento getStatusAgendamento() {
        return StatusAgendamento.toEnum(this.statusAgendamento);
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento.getCod();
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", cliente=" + cliente +
                ", statusAgendamento=" + statusAgendamento +
                ", servico=" + servico +
                ", pagamento=" + pagamento +
                ", valor=" + valor +
                ", produtos=" + produtos +
                '}';
    }
}
