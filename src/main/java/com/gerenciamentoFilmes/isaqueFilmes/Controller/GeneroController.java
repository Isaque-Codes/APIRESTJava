package com.gerenciamentoFilmes.isaqueFilmes.Controller;


import com.gerenciamentoFilmes.isaqueFilmes.Model.Filme;
import com.gerenciamentoFilmes.isaqueFilmes.Model.Genero;
import com.gerenciamentoFilmes.isaqueFilmes.Service.GeneroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
@CrossOrigin("*")
@Tag(name = "Generos", description = "Endpoint para CRUD de generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @PostMapping
    @Operation(summary = "Cadastar generos")
    public ResponseEntity<Genero> cadastrarGenero(Genero genero) {
        return new ResponseEntity<>(generoService.cadastrarGenero(genero), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar generos")
    public ResponseEntity<List<Genero>> listarGeneros() {
        List<Genero> listaGeneros = generoService.listarGenero();

        if (listaGeneros.isEmpty()) {
            return new ResponseEntity<>(listaGeneros, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listaGeneros, HttpStatus.OK);
    }

    @DeleteMapping("/{idGenero}")
    @Operation(summary = "Deletar genero por id")
    public ResponseEntity<Genero> deletarGenero(@PathVariable long idGenero) {
        generoService.deletarGenero(idGenero);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
