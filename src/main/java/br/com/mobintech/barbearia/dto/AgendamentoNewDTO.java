package br.com.mobintech.barbearia.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.mobintech.barbearia.models.Agendamento;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class AgendamentoNewDTO implements Serializable {

    private Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "HH:mm", timezone = "America/Sao_Paulo")
    private LocalTime horaInicio;
    private Integer status;
    private Long idCliente;
    private Long idProfissional;
    private Long idServico;

    public AgendamentoNewDTO(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.data = agendamento.getData();
        this.horaInicio = agendamento.getHoraInicio();
        this.status = agendamento.getStatus();
        this.idCliente = agendamento.getCliente().getId();
        this.idProfissional = agendamento.getProfissional().getId();
        this.idServico = agendamento.getServico().getId();
    }
}