package com.canuto.demo.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {

    UUID id;

    @NotEmpty(message="Preenchimento obrigatório")
    @Size(min=1, max=255, message="O tamanho deve ser entre 1 e 255 caracteres")
    String nome;
}
