package com.tech.barbeariaback.controller;

import com.tech.barbeariaback.dto.FuncionarioDTO;
import com.tech.barbeariaback.models.Funcionario;
import com.tech.barbeariaback.models.Usuario;
import com.tech.barbeariaback.service.FuncionarioService;
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
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Void>create(@Valid @RequestBody FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = funcionarioService.create(funcionarioDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(funcionario.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity< List<Usuario> >findAll(){
        return ResponseEntity.ok().body(funcionarioService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario>findById(@PathVariable Long id){
        return ResponseEntity.ok().body(funcionarioService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void>update(@Valid @RequestBody FuncionarioDTO funcionarioDTO, @PathVariable Long id){
        funcionarioService.update(id, funcionarioDTO);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        funcionarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
