package com.tech.barbeariaback.controller;

import com.tech.barbeariaback.dto.BarbeiroDTO;
import com.tech.barbeariaback.models.Barbeiro;
import com.tech.barbeariaback.models.Usuario;
import com.tech.barbeariaback.service.BarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "barbeiros")
public class BarbeiroController {
    @Autowired
    private BarbeiroService barbeiroService;

    @GetMapping
    public ResponseEntity< List<Usuario> > findAll(){
        return ResponseEntity.ok().body(barbeiroService.findAll());
    }
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody BarbeiroDTO barbeiroDTO){
        Barbeiro barbeiro = barbeiroService.fromDTO(barbeiroDTO);
        barbeiro = barbeiroService.insert(barbeiro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(barbeiro.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

}
