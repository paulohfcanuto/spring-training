package com.canuto.cursomc.services;

import com.canuto.cursomc.domain.Categoria;
import com.canuto.cursomc.exception.NotFoundException;
import com.canuto.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository repo;

    @Autowired
    public CategoriaService(CategoriaRepository repo) {
        this.repo = repo;
    }

    public Categoria buscar(Integer id) {
        Optional<Categoria > obj = repo.findById(id);
        return obj.orElseThrow(() -> new NotFoundException("Categoria não encontrada."));
    }
}
