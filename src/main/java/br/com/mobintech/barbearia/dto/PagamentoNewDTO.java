package br.com.mobintech.barbearia.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class PagamentoNewDTO implements Serializable {
    private Long id;
    @NotNull(message = "O campo 'idTipoPagamento' é obrigatório")
    private Long idTipoPagamento;
    @NotNull(message = "O campo 'idAgendamento' é obrigatório")
    private Long idAgendamento;

}
