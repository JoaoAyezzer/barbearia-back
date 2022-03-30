package br.com.mobintech.barbearia.controller;

import br.com.mobintech.barbearia.dto.ProdutoDTO;
import br.com.mobintech.barbearia.dto.ProdutoNewDTO;
import br.com.mobintech.barbearia.models.Produto;
import br.com.mobintech.barbearia.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;
    @PreAuthorize("hasAnyRole('ADMIN', 'BARBEIRO')")
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ProdutoNewDTO produtoNewDTO){
        Produto produto = service.create(produtoNewDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produto.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @GetMapping
    public ResponseEntity< List<ProdutoDTO> > findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody ProdutoNewDTO produtoNewDTO){
        service.update(id, produtoNewDTO);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
