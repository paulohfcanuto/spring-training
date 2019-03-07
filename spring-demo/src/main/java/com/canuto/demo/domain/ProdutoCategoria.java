package com.canuto.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUTO_CATEGORIA")
public class ProdutoCategoria {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @MapsId("PRODUTO_ID")
    @JoinColumn(name = "PRODUTO_ID")
    private Produto produto;

    @ManyToOne
    @MapsId("CATEGORIA_ID")
    @JoinColumn(name = "CATEGORIA_ID")
    private Categoria categoria;
}
