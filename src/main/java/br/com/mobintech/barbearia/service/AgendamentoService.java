package br.com.mobintech.barbearia.service;

import br.com.mobintech.barbearia.dto.AgendamentoDTO;
import br.com.mobintech.barbearia.dto.AgendamentoNewDTO;
import br.com.mobintech.barbearia.models.Agendamento;
import br.com.mobintech.barbearia.models.Barbeiro;
import br.com.mobintech.barbearia.models.Cliente;
import br.com.mobintech.barbearia.models.Servico;
import br.com.mobintech.barbearia.models.enums.StatusAgendamento;
import br.com.mobintech.barbearia.repositories.AgendamentoRepository;
import br.com.mobintech.barbearia.service.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {
    @Autowired
    AgendamentoRepository agendamentoRepository;
    @Autowired
    ServicoService servicoService;
    @Autowired
    ClienteService clienteService;
    @Autowired
    BarbeiroService barbeiroService;

    public Agendamento create(AgendamentoNewDTO dto){
        return agendamentoRepository.save(fromNewDTO(dto));
    }

    public List<AgendamentoDTO> findAll(){
        return agendamentoRepository.findAll()
                .stream()
                .map(AgendamentoDTO::new)
                .collect(Collectors.toList());
    }

    public Agendamento findById(Long id){
        Optional<Agendamento> agendamento = agendamentoRepository.findById(id);
        return agendamento.orElseThrow(
                    () -> new ObjectNotfoundException(
                        "Agendamento com Id: " + id + ", não encontrado na base de dados"
                    )
        );
    }
    public Agendamento update(Long id, AgendamentoNewDTO agendamentoNewDTO){
        findById(id);
        agendamentoNewDTO.setId(id);
        return agendamentoRepository.save(fromNewDTO(agendamentoNewDTO));
    }
    public void delete(Long id){
        findById(id);
        agendamentoRepository.deleteById(id);
    }
    public Agendamento fromNewDTO(AgendamentoNewDTO dto){
        Servico servico = servicoService.findById(dto.getIdServico());
        Cliente cliente = clienteService.findById(dto.getIdCliente());
        Barbeiro profissional = barbeiroService.findById(dto.getIdProfissional());
        LocalTime horaFim = dto.getHoraInicio().plusMinutes(servico.getTempoEmMinutos().getMinute());
        Agendamento agendamento = new Agendamento(
                dto.getId(),
                dto.getData(),
                dto.getHoraInicio(),
                horaFim,
                (dto.getStatus() == null) ? StatusAgendamento.AGENDADO.getCod() : dto.getStatus(),
                servico.getValor(),
                cliente,
                profissional,
                servico
        );

        return agendamento;
    }

}
