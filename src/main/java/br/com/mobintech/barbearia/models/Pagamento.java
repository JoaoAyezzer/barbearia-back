package br.com.mobintech.barbearia.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pagamentos")
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @Column
    private Double valorBruto;
    @Column
    private Double valorLiquido;
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern="dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
    private LocalDateTime dataPagamento;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataRecebimento;
    @ManyToOne
    @JoinColumn(name = "TIPO_PAGAMENTO_ID")
    private TipoPagamento tipoPagamento;
    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "AGENDAMENTO_ID")
    private Agendamento agendamento;

    public Pagamento(Long id, Double valorBruto, Double valorLiquido, LocalDateTime dataPagamento, LocalDate dataRecebimento, TipoPagamento tipoPagamento, Agendamento agendamento) {
        this.id = id;
        this.valorBruto = valorBruto;
        this.valorLiquido = valorLiquido;
        this.dataPagamento = dataPagamento;
        this.dataRecebimento = dataRecebimento;
        this.tipoPagamento = tipoPagamento;
        this.agendamento = agendamento;
    }
}
