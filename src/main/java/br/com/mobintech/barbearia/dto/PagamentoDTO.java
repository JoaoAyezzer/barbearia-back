package br.com.mobintech.barbearia.dto;

import br.com.mobintech.barbearia.models.Pagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PagamentoDTO implements Serializable {
    private Long id;
    private Double valorBruto;
    private Double valorLiquido;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
    private LocalDateTime dataPagamento;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataRecebimento;
    private Long idTipoPagamento;
    private Long idAgendamento;

    public PagamentoDTO(Pagamento pagamento) {
        this.id = pagamento.getId();
        this.valorBruto = pagamento.getValorBruto();
        this.valorLiquido = pagamento.getValorLiquido();
        this.dataPagamento = pagamento.getDataPagamento();
        this.dataRecebimento = pagamento.getDataRecebimento();
        this.idTipoPagamento = pagamento.getTipoPagamento().getId();
        this.idAgendamento = pagamento.getAgendamento().getId();
    }

}
