package com.tech.barbeariaback.controller;

import com.tech.barbeariaback.dto.FuncionarioDTO;
import com.tech.barbeariaback.models.Funcionario;
import com.tech.barbeariaback.models.Usuario;
import com.tech.barbeariaback.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity< List<Usuario> > findAll(){
        return ResponseEntity.ok().body(funcionarioService.findAll());
    }
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = funcionarioService.fromDTO(funcionarioDTO);
        funcionario = funcionarioService.insert(funcionario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(funcionario.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

}
