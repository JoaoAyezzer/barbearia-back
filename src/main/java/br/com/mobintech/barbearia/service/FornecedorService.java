package br.com.mobintech.barbearia.service;

import br.com.mobintech.barbearia.repositories.FornecedorRepository;
import br.com.mobintech.barbearia.dto.FornecedorDTO;
import br.com.mobintech.barbearia.models.Fornecedor;
import br.com.mobintech.barbearia.service.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    public List<FornecedorDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(FornecedorDTO::new)
                .collect(Collectors.toList());
    }

    public Fornecedor findById(Long id) {
        Optional<Fornecedor> fornecedor = repository.findById(id);
        return fornecedor.orElseThrow(
                () -> new ObjectNotfoundException(
                        "Fornecedor com id: " + id +" não encontrado na base de dados!"
                )
        );
    }

    public Fornecedor create(FornecedorDTO fornecedorDTO) {
       return repository.save(fromDTO(fornecedorDTO));
    }

    public Fornecedor update(Long id, FornecedorDTO fornecedorDTO) {
        findById(id);
        fornecedorDTO.setId(id);
       return repository.save(fromDTO(fornecedorDTO));
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public Fornecedor fromDTO(FornecedorDTO fornecedorDTO){
        return new Fornecedor(
                fornecedorDTO.getId(),
                fornecedorDTO.getNome(),
                fornecedorDTO.getTelefone(),
                fornecedorDTO.getEmail());
    }

}
