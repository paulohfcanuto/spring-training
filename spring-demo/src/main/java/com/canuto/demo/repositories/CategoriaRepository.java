package com.canuto.demo.repositories;

import com.canuto.demo.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, UUID> {

}
