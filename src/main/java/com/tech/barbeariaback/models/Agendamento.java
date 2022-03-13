package com.tech.barbeariaback.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tech.barbeariaback.models.enums.StatusAgendamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Entity
public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date dataInicial;
    @Column
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date dataFinal;
    @Column
    private Integer status;
    @Column
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "PROFISSIONAL_ID")
    private FuncionarioComissionado profissional;
    @ManyToOne
    @JoinColumn(name = "SERVICO_ID")
    private Servico servico;
    @OneToOne
    @JoinColumn(name = "PAGAMENTO_ID")
    private Pagamento pagamento;
    @ManyToMany
    @JoinTable(name = "PRODUTO_AGENDAMENTO", joinColumns = @JoinColumn(name = "agendamento_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos;

    public Agendamento() {
    }

    public Agendamento(Long id, Date dataInicial, Date dataFinal, Cliente cliente, StatusAgendamento statusAgendamento, Servico servico, Pagamento pagamento, Double valor) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cliente = cliente;
        this.status = statusAgendamento.getCod();
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
        return StatusAgendamento.toEnum(this.status);
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.status = statusAgendamento.getCod();
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
                ", statusAgendamento=" + status +
                ", servico=" + servico +
                ", pagamento=" + pagamento +
                ", valor=" + valor +
                ", produtos=" + produtos +
                '}';
    }
}
