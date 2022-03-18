package com.tech.barbeariaback.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tech.barbeariaback.models.enums.StatusAgendamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agendamentos")
public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public StatusAgendamento getStatusAgendamento() {
        return StatusAgendamento.toEnum(this.status);
    }
    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.status = statusAgendamento.getCod();
    }

}
