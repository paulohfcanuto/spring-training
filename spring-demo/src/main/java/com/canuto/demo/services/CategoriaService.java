package com.canuto.demo.services;

import com.canuto.demo.domain.Categoria;
import com.canuto.demo.domain.QCategoria;
import com.canuto.demo.domain.dto.CategoriaDto;
import com.canuto.demo.exception.DataIntegrityException;
import com.canuto.demo.exception.NotFoundException;
import com.canuto.demo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.List;
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
        Optional<Categoria> categoria = repo.findById(id);
        return categoria.orElseThrow(() -> new NotFoundException("Categoria não encontrada."));
    }

    public List<Categoria> buscarPorNome(String nome) {
        final BooleanExpression condicao = QCategoria.categoria.nome.eq(nome);
        final List<Categoria> categorias = repo.findAll(condicao);

        if (categorias.isEmpty()) {
            throw new NotFoundException("Categoria " + nome + " não encontrada.");
        }

        return categorias;
    }

    public Categoria gravar(CategoriaDto categoriaDto) {
        return repo.save(fromDTO(categoriaDto));
    }

    public Categoria atualizar(UUID uuid, CategoriaDto categoriaDto) {
        Categoria novaCategria = buscar(uuid);
        novaCategria.setNome(categoriaDto.getNome());
        return repo.save(novaCategria);
    }

    public void deletar(UUID id) {
        buscar(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
        }
    }

    private static Categoria fromDTO(CategoriaDto objDto) {
        return new Categoria(objDto.getId(), objDto.getNome());
    }
}
