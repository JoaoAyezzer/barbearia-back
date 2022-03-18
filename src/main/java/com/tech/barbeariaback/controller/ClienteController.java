package com.tech.barbeariaback.controller;

import com.amazonaws.Response;
import com.tech.barbeariaback.dto.ClienteDTO;
import com.tech.barbeariaback.models.Cliente;
import com.tech.barbeariaback.models.Usuario;
import com.tech.barbeariaback.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity< List<Cliente> > findAll(){
        List<Cliente> clientes = clienteService.findAll()
                .stream()
                .map( usuario -> clienteService.usuarioFromCliente(usuario) )
                .collect( Collectors.toList() );
        return ResponseEntity.ok().body(clientes);
    }
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteDTO clienteDTO){
        Cliente cliente = clienteService.fromDTO(clienteDTO);
        cliente = clienteService.insert(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cliente.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

}
