package br.com.mobintech.barbearia.controller;

import br.com.mobintech.barbearia.dto.FornecedorDTO;
import br.com.mobintech.barbearia.service.FornecedorService;
import br.com.mobintech.barbearia.models.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody FornecedorDTO fornecedorDTO){
        Fornecedor barbeiro = fornecedorService.create(fornecedorDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(barbeiro.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity< List<FornecedorDTO> > findAll(){
        return ResponseEntity.ok().body(fornecedorService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<FornecedorDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(
                new FornecedorDTO(
                        fornecedorService.findById(id)
                )
        );
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody FornecedorDTO fornecedorDTO){
        fornecedorService.update(id, fornecedorDTO);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        fornecedorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
