package com.tech.barbeariaback.controller;

import com.tech.barbeariaback.dto.BarbeiroDTO;
import com.tech.barbeariaback.models.Barbeiro;
import com.tech.barbeariaback.models.Usuario;
import com.tech.barbeariaback.service.BarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "funcionarios")
public class BarbeiroController {

    @Autowired
    private BarbeiroService barbeiroService;

    @PostMapping(value = "/barbeiros")
    public ResponseEntity<Void> create(@Valid @RequestBody BarbeiroDTO barbeiroDTO){
        Barbeiro barbeiro = barbeiroService.create(barbeiroDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(barbeiro.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/barbeiros")
    public ResponseEntity< List<Usuario> > findAll(){
        return ResponseEntity.ok().body(barbeiroService.findAll());
    }

    @PutMapping(value = "/barbeiros/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody BarbeiroDTO barbeiroDTO){
        barbeiroService.update(id, barbeiroDTO);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/barbeiros/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        barbeiroService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
