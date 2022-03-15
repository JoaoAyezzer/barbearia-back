package com.tech.barbeariaback.controller;

import com.tech.barbeariaback.models.Usuario;
import com.tech.barbeariaback.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping(value = "/{value}")
    public ResponseEntity<List<Usuario>> insert(@PathVariable String value){
        return ResponseEntity.ok().body(usuarioService.findAllByPerfil(value));
    }


}
