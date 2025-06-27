package com.gerenciamentoFilmes.isaqueFilmes.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFilme;

    @NotBlank(message = "O nome do filme Ã© obrigatÃ³rio!")
    private String nomeFilme;

    @NotNull(message = "O ano de lanÃ§amento Ã© obrigatÃ³rio!")
    @Min(value = 1888, message = "Ano de lanÃ§amento Ã© invÃ¡lido")
    private Integer anoLancamentoFilme;

    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmeGenero> generos = new ArrayList();
}
