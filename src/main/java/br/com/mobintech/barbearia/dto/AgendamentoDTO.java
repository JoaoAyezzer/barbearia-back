package br.com.mobintech.barbearia.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.mobintech.barbearia.models.Agendamento;
import br.com.mobintech.barbearia.models.enums.StatusAgendamento;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
public class AgendamentoDTO implements Serializable {

    private Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "HH:mm", timezone = "America/Sao_Paulo")
    private LocalTime horaInicio;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "HH:mm", timezone = "America/Sao_Paulo")
    private LocalTime horaFim;
    private Integer status;
    private Long idCliente;
    private String nomeCliente;
    private String telefoneCliente;
    private String emailCliente;
    private Long idProfissional;
    private String nomeProfissional;
    private Long idServico;
    private String nomeServico;
    private Double valor;
    private List<ProdutoDTO> produtos;

    public AgendamentoDTO(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.data = agendamento.getData();
        this.horaInicio = agendamento.getHoraInicio();
        this.horaFim = agendamento.getHoraFim();
        this.status = agendamento.getStatus();
        this.idCliente = agendamento.getCliente().getId();
        this.nomeCliente = agendamento.getCliente().getNome();
        this.telefoneCliente = agendamento.getCliente().getTelefone();
        this.emailCliente = agendamento.getCliente().getEmail();
        this.idProfissional = agendamento.getProfissional().getId();
        this.nomeProfissional = agendamento.getProfissional().getNome();
        this.idServico = agendamento.getServico().getId();
        this.nomeServico = agendamento.getServico().getNome();
        this.valor = agendamento.getValor();
        this.produtos = agendamento.getProdutos()
                .stream()
                .map(ProdutoDTO::new)
                .collect(java.util.stream.Collectors.toList());
    }
    public StatusAgendamento getStatus() {
        return StatusAgendamento.toEnum(this.status);
    }
    public void setStatus(StatusAgendamento statusAgendamento) {
        this.status = statusAgendamento.getCod();
    }
}