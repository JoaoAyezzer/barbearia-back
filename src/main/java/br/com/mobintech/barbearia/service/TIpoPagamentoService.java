package br.com.mobintech.barbearia.service;

import br.com.mobintech.barbearia.dto.TipoPagamentoDTO;
import br.com.mobintech.barbearia.models.TipoPagamento;
import br.com.mobintech.barbearia.repositories.TipoPagamentoRepository;
import br.com.mobintech.barbearia.service.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TIpoPagamentoService {

    @Autowired
    private TipoPagamentoRepository repository;

    public TipoPagamento create(TipoPagamentoDTO tipoPagamentoDTO) {
        return repository.save(fromDTO(tipoPagamentoDTO));
    }

    public List<TipoPagamento> findAll() {
        return repository.findAll();
    }

    public TipoPagamento findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotfoundException(
                        "Tipo de pagamento ID: " + id + " não encontrado!"
                )
        );
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
    public TipoPagamento fromDTO(TipoPagamentoDTO tipoPagamentoDTO) {
        return new TipoPagamento(
                tipoPagamentoDTO.getId(),
                tipoPagamentoDTO.getNome(),
                tipoPagamentoDTO.getTaxaRecebimento(),
                tipoPagamentoDTO.getPrazoRecebimento());
    }

    public void update(Long id, TipoPagamentoDTO tipoPagamentoDTO) {
        findById(id);
        tipoPagamentoDTO.setId(id);
        repository.save(fromDTO(tipoPagamentoDTO));
    }
}
