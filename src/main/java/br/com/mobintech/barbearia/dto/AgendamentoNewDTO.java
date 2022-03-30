package br.com.mobintech.barbearia.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.mobintech.barbearia.models.Agendamento;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AgendamentoNewDTO implements Serializable {

    private Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
    private LocalDateTime dataInicial;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
    private LocalDateTime dataFinal;
    private Integer status;
    private Long idCliente;
    private Long idProfissional;
    private Long idServico;

    public AgendamentoNewDTO(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.dataInicial = agendamento.getDataHoraInicio();
        this.dataFinal = agendamento.getDataHoraFim();
        this.status = agendamento.getStatus();
        this.idCliente = agendamento.getCliente().getId();
        this.idProfissional = agendamento.getProfissional().getId();
        this.idServico = agendamento.getServico().getId();
    }
}