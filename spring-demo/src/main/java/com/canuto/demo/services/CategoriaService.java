package com.canuto.demo.services;

import com.canuto.demo.domain.Categoria;
import com.canuto.demo.domain.QCategoria;
import com.canuto.demo.exception.NotFoundException;
import com.canuto.demo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaService {

    private final CategoriaRepository repo;

    @Autowired
    public CategoriaService(CategoriaRepository repo) {
        this.repo = repo;
    }

    public Categoria buscar(UUID id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new NotFoundException("Categoria não encontrada."));
    }

    public Categoria gravar(Categoria obj) {
        return repo.save(obj);
    }

    public Iterable<Categoria> buscarPorNome(String nome) {
        final BooleanExpression condicao = QCategoria.categoria.nome.eq(nome);
        return repo.findAll(condicao);
    }
}
