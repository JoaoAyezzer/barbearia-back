package br.com.mobintech.barbearia.dto;

import br.com.mobintech.barbearia.models.Agendamento;
import br.com.mobintech.barbearia.models.Pagamento;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PagamentoDTO implements Serializable {
    private Long id;
    private Double valorBruto;
    private Double valorLiquido;
    private LocalDateTime dataPagamento;
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
