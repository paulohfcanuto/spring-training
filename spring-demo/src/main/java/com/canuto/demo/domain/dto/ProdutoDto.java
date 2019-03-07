package com.canuto.demo.domain.dto;

import com.canuto.demo.domain.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    UUID id;

    @NotEmpty(message="O nome do produto deve ser preenchido")
    @Size(min=1, max=255, message="O tamanho deve ser entre 1 e 255 caracteres")
    String nome;

    @NotEmpty(message="O preço do produto deve ser preenchido")
    @DecimalMin(value = "0.1", inclusive = true)
    @DecimalMax(value = "9.9", inclusive = true)
    Double preco;

    @NotEmpty(message="Preenchimento obrigatório")
    @Size(min=1)
    Set<Categoria> categorias;
}
