package com.gerenciamentoFilmes.isaqueFilmes.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "filmeGenero")
public class FilmeGenero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilmeGenero;

    @ManyToOne
    @JoinColumn(name = "idFilme")
    @JsonIgnore
    private Filme filme;

    @ManyToOne
    @JoinColumn(name = "idGenero")
    @JsonIgnore
    private Genero genero;
}
