package com.canuto.demo.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Categorias")
public class Categoria {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "NOME")
    private String nome;

    public Categoria() {
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
