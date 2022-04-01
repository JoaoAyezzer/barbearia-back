package br.com.mobintech.barbearia.controller;

import br.com.mobintech.barbearia.dto.PagamentoDTO;
import br.com.mobintech.barbearia.dto.PagamentoNewDTO;
import br.com.mobintech.barbearia.models.Pagamento;
import br.com.mobintech.barbearia.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody PagamentoNewDTO newDTO){
        Pagamento pagamento = service.create(newDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pagamento.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity< List<PagamentoDTO> > findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity< PagamentoDTO > findById(@PathVariable Long id){
        return ResponseEntity.ok().body(new PagamentoDTO(service.findById(id)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody PagamentoNewDTO newDTO){
        service.update(id, newDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
