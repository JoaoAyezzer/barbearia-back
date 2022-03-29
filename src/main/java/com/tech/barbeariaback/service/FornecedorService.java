package com.tech.barbeariaback.service;

import com.tech.barbeariaback.dto.FornecedorDTO;
import com.tech.barbeariaback.models.Fornecedor;
import com.tech.barbeariaback.repositories.FornecedorRepository;
import com.tech.barbeariaback.service.exceptions.ObjectNotfoundException;
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
                () -> new ObjectNotfoundException("Serviço não encontrado")
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
