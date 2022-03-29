package com.tech.barbeariaback.service;

import com.tech.barbeariaback.dto.AgendamentoDTO;
import com.tech.barbeariaback.dto.AgendamentoNewDTO;
import com.tech.barbeariaback.models.Agendamento;
import com.tech.barbeariaback.models.Barbeiro;
import com.tech.barbeariaback.models.Cliente;
import com.tech.barbeariaback.models.Servico;
import com.tech.barbeariaback.models.enums.StatusAgendamento;
import com.tech.barbeariaback.repositories.AgendamentoRepository;
import com.tech.barbeariaback.service.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
              () -> new ObjectNotfoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Agendamento.class.getName())
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
        LocalDateTime dataHoraFim = dto.getDataInicial().plusMinutes(servico.getTempoEmMinutos().getMinute());
        Agendamento agendamento = new Agendamento(
                dto.getId(),
                dto.getDataInicial(),
                dataHoraFim,
                (dto.getStatus() == null) ? StatusAgendamento.AGENDADO.getCod() : dto.getStatus(),
                servico.getValor(),
                cliente,
                profissional,
                servico
        );

        return agendamento;
    }
}
