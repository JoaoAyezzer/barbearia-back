package br.com.mobintech.barbearia.dto;

import br.com.mobintech.barbearia.models.TipoPagamento;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class TipoPagamentoDTO implements Serializable {
    private Long id;
    private String nome;
    private Float taxaRecebimento;
    private Long prazoRecebimento;

    public TipoPagamentoDTO(TipoPagamento tipoPagamento) {
        this.id = tipoPagamento.getId();
        this.nome = tipoPagamento.getNome();
        this.taxaRecebimento = tipoPagamento.getTaxaRecebimento();
        this.prazoRecebimento = tipoPagamento.getPrazoRecebimento();
    }
}
