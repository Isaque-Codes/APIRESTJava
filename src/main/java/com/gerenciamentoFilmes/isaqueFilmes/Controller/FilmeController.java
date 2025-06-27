package com.gerenciamentoFilmes.isaqueFilmes.Controller;

import com.gerenciamentoFilmes.isaqueFilmes.DTO.FilmeDTO;
import com.gerenciamentoFilmes.isaqueFilmes.DTO.FilmeResponseDTO;
import com.gerenciamentoFilmes.isaqueFilmes.Model.Filme;
import com.gerenciamentoFilmes.isaqueFilmes.Service.FilmeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@CrossOrigin("*")
@Tag(name = "Filmes", description = "Endpoint para CRUD de filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping
    @Operation(summary = "Cadastrar filmes")
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody FilmeDTO filmeDTO) {
        return new ResponseEntity<>(filmeService.criarFilme(filmeDTO), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar todos os filmes")
    public ResponseEntity<List<FilmeResponseDTO>> listarFilmes() {
        List<FilmeResponseDTO> filmes = filmeService.listarTodosFilmes();

        if (filmes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }

    @DeleteMapping("/{idFilme}")
    @Operation(summary = "Deletar filmes por id")
    public ResponseEntity<Filme> deletarFilme(@PathVariable long idFilme) {
        filmeService.deletarFilme(idFilme);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{idFilme}")
    @Operation(summary = "Editar informações do filme por id")
    public ResponseEntity<Filme> atualizarFilme(@RequestBody FilmeDTO filmeDTO) {
        Filme filmeAtualizado = filmeService.criarFilme(filmeDTO);

        return ResponseEntity.ok(filmeAtualizado);
    }

    @GetMapping("/{idFilme}")
    @Operation(summary = "Buscar filme por id")
    public ResponseEntity<Filme> buscarFilmePorId(@PathVariable long idFilme) {
        return new ResponseEntity<>(filmeService.buscarFilmePorId(idFilme), HttpStatus.OK);
    }
}
