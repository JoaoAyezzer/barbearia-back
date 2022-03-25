package com.tech.barbeariaback.controller;

import com.tech.barbeariaback.dto.ServicoDTO;
import com.tech.barbeariaback.models.Servico;
import com.tech.barbeariaback.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ServicoDTO servicoDTO){
        Servico servico = servicoService.create(servicoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(servico.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity< List<ServicoDTO> > findAll(){
        return ResponseEntity.ok().body(servicoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(servicoService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody ServicoDTO servicoDTO){
        servicoService.update(id, servicoDTO);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        servicoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
