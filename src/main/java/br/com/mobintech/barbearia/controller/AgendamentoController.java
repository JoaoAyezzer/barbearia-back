package br.com.mobintech.barbearia.controller;

import br.com.mobintech.barbearia.dto.AgendamentoDTO;
import br.com.mobintech.barbearia.dto.AgendamentoNewDTO;
import br.com.mobintech.barbearia.models.Agendamento;
import br.com.mobintech.barbearia.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "agendamentos")
public class AgendamentoController {
    @Autowired
    private AgendamentoService service;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody AgendamentoNewDTO dto){
        Agendamento agendamento = service.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(agendamento.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity< List<AgendamentoDTO> > findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AgendamentoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
    @GetMapping(value = "/data/{data}")
    public ResponseEntity<Agendamento> findByData(@PathVariable String data){
        return ResponseEntity.ok().body(service.findByData(data));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void>update(@Valid @RequestBody AgendamentoNewDTO dto, @PathVariable Long id){
        service.update(id, dto);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
