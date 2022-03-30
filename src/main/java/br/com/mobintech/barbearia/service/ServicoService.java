package br.com.mobintech.barbearia.service;

import br.com.mobintech.barbearia.dto.ServicoDTO;
import br.com.mobintech.barbearia.models.Servico;
import br.com.mobintech.barbearia.repositories.ServicoRepository;
import br.com.mobintech.barbearia.service.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;


    public List<ServicoDTO> findAll(){
        return servicoRepository.findAll()
                .stream()
                .map(ServicoDTO::new)
                .collect(Collectors.toList());
    }

    public Servico findById(Long id) {
        return servicoRepository.findById(id).orElseThrow(
                () -> new ObjectNotfoundException(
                        "Produto com Id: " + id + ", não encontrado na base de dados"
                )
        );
    }

    public Servico create(ServicoDTO servicoDTO) {
       return servicoRepository.save(fromDTO(servicoDTO));
    }

    public Servico update(Long id, ServicoDTO servicoDTO) {
        findById(id);
        servicoDTO.setId(id);
       return servicoRepository.save(fromDTO(servicoDTO));
    }

    public void delete(Long id) {
        findById(id);
        servicoRepository.deleteById(id);
    }

    public Servico fromDTO(ServicoDTO servicoDTO){
        Servico servico = new  Servico(
                (servicoDTO.getId() == null) ? null : servicoDTO.getId(),
                servicoDTO.getNome(),
                servicoDTO.getValor(),
                servicoDTO.getTempo());
                servico.setDiasDeAtendimento(servicoDTO.pegaDiasDeAtendimento());
        return servico;

    }
}
