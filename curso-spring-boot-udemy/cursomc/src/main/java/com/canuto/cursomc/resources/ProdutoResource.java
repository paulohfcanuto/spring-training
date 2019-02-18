package com.canuto.cursomc.resources;

import com.canuto.cursomc.domain.Produto;
import com.canuto.cursomc.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoResource(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listar(@PathVariable Integer id){
        Produto produto = produtoService.buscar(id);
        return ResponseEntity.ok().body(produto);
    }
}
