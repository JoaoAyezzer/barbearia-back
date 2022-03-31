package br.com.mobintech.barbearia.controller;

import br.com.mobintech.barbearia.dto.TipoPagamentoDTO;
import br.com.mobintech.barbearia.models.TipoPagamento;
import br.com.mobintech.barbearia.service.TIpoPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "tipo-pagamento")
public class TipoPagamentoController {

    @Autowired
    private TIpoPagamentoService service;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody TipoPagamentoDTO tipoPagamentoDTO){
        TipoPagamento tipoPagamento = service.create(tipoPagamentoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tipoPagamento.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity< List<TipoPagamento> > findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity< TipoPagamento > findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody TipoPagamentoDTO tipoPagamentoDTO){
        service.update(id, tipoPagamentoDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
