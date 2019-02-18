package com.canuto.demo.resources;

import com.canuto.demo.domain.Categoria;
import com.canuto.demo.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;


@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaResource(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listar(@PathVariable UUID id){
        Categoria categoria = categoriaService.buscar(id);
        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody Categoria categoria){
        Categoria categoriaCriada = categoriaService.gravar(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(categoriaCriada.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
