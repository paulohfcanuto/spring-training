package com.canuto.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CATEGORIAS")
public class Categoria {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "NOME")
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "CATEGORIAS")
    private Set<ProdutoCategoria> produtos;

    public Categoria(UUID id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
