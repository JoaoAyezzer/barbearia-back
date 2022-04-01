package br.com.mobintech.barbearia.service;

import br.com.mobintech.barbearia.dto.PagamentoDTO;
import br.com.mobintech.barbearia.dto.PagamentoNewDTO;
import br.com.mobintech.barbearia.models.Agendamento;
import br.com.mobintech.barbearia.models.Pagamento;
import br.com.mobintech.barbearia.models.TipoPagamento;
import br.com.mobintech.barbearia.repositories.PagamentoRepository;
import br.com.mobintech.barbearia.service.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;
    @Autowired
    private TIpoPagamentoService tipoPagamentoService;
    @Autowired
    private AgendamentoService agendamentoService;

    public Pagamento create(PagamentoNewDTO dto) {
        return repository.save(fromDTO(dto));
    }

    public List<PagamentoDTO> findAll() {
        List<PagamentoDTO> pagamentoDTOS = repository.findAll()
                .stream()
                .map(PagamentoDTO::new)
                .collect(Collectors.toList());
        return pagamentoDTOS;
    }

    public Pagamento findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotfoundException(
                        "Tipo de pagamento ID: " + id + " não encontrado!"
                )
        );
    }
    public void update(Long id, PagamentoNewDTO dto) {
        findById(id);
        repository.save(fromDTO(dto));
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public Pagamento fromDTO(PagamentoNewDTO dto ) {
        Agendamento agendamento = agendamentoService.findById(dto.getIdAgendamento());
        TipoPagamento tipoPagamento = tipoPagamentoService.findById(dto.getIdTipoPagamento());
        LocalDateTime data = LocalDateTime.now();
        Double valorLiquido = agendamento.getValor() - (tipoPagamento.getTaxaRecebimento() * (agendamento.getValor() /100));
        LocalDate dataRecebimento = LocalDate.from(data.plusDays(tipoPagamento.getPrazoRecebimento()));
        Pagamento pagamento = new  Pagamento(
                dto.getId(),
                agendamento.getValor(),
                valorLiquido,
                data,
                dataRecebimento,
                tipoPagamento,
                agendamento
        );
        return pagamento;
    }


}
