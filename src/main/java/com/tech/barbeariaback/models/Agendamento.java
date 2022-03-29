package com.tech.barbeariaback.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tech.barbeariaback.models.enums.StatusAgendamento;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "agendamentos")
public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern="dd-MM-yyyy HH:mm", timezone = "America/Sao_Paulo")
    private LocalDateTime dataHoraInicio;
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern="dd/MM/yyyy HH:mm",timezone = "America/Sao_Paulo")
    private LocalDateTime dataHoraFim;
    @Column
    private Integer status;
    @Column
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "PROFISSIONAL_ID")
    private Barbeiro profissional;
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

    public Agendamento(Long id, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, Integer status, Double valor, Cliente cliente, Barbeiro profissional, Servico servico) {
        this.id = id;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.status = status;
        this.valor = valor;
        this.cliente = cliente;
        this.profissional = profissional;
        this.servico = servico;
    }
}
