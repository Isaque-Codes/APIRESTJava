package com.gerenciamentoFilmes.isaqueFilmes.Service;

import com.gerenciamentoFilmes.isaqueFilmes.Model.Filme;
import com.gerenciamentoFilmes.isaqueFilmes.Model.Genero;
import com.gerenciamentoFilmes.isaqueFilmes.Repository.IGeneroRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class GeneroService {

    @Autowired
    private IGeneroRepository generoRepository;

    public Genero cadastrarGenero(@RequestBody Genero genero) {
        return generoRepository.save(genero);
    }

    public List<Genero> listarGenero() {
        return generoRepository.findAll();
    }

    public void deletarGenero(long idGenero) {
        Genero generoEncontrado = generoRepository.findById(idGenero)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum genero foi encontrado!"));

        generoRepository.delete(generoEncontrado);
    }
}
