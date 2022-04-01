package br.com.mobintech.barbearia.models;

import br.com.mobintech.barbearia.models.enums.StatusAgendamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate data;
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern="HH:mm", timezone = "America/Sao_Paulo")
    private LocalTime horaInicio;
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern="HH:mm", timezone = "America/Sao_Paulo")
    private LocalTime horaFim;
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
    @OneToOne(cascade=CascadeType.ALL, mappedBy="agendamento")
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

    public Agendamento(Long id, LocalDate data, LocalTime horaInicio, LocalTime horaFim, Integer status, Double valor, Cliente cliente, Barbeiro profissional, Servico servico) {
        this.id = id;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.status = status;
        this.valor = valor;
        this.cliente = cliente;
        this.profissional = profissional;
        this.servico = servico;

    }
}
