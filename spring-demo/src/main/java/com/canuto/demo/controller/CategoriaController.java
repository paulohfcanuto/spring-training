package com.canuto.demo.controller;

import com.canuto.demo.domain.Categoria;
import com.canuto.demo.domain.dto.CategoriaDto;
import com.canuto.demo.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> listarPorId(@PathVariable UUID uuid){
        Categoria categoria = categoriaService.buscar(uuid);
        return ResponseEntity.ok().body(categoria);
    }

    @GetMapping()
    public ResponseEntity<?> listarTodosPorNome(@NonNull @RequestParam(value="nome") String nome) {
        List<Categoria> categorias = categoriaService.buscarPorNome(nome);
        return ResponseEntity.ok().body(categorias);
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody CategoriaDto categoriaDto){
        Categoria categoriaCriada = categoriaService.gravar(categoriaDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(categoriaCriada.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> atualizar(@Valid @RequestBody CategoriaDto categoriaDto, @PathVariable UUID uuid) {
        Categoria categoria = categoriaService.atualizar(uuid, categoriaDto);
        return ResponseEntity.ok().body(categoria);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> deletar(@PathVariable UUID uuid) {
        categoriaService.deletar(uuid);
        return ResponseEntity.ok().build();
    }
}
