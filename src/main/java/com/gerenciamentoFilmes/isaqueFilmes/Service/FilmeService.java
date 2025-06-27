package com.gerenciamentoFilmes.isaqueFilmes.Service;

import com.gerenciamentoFilmes.isaqueFilmes.DTO.FilmeDTO;
import com.gerenciamentoFilmes.isaqueFilmes.DTO.FilmeResponseDTO;
import com.gerenciamentoFilmes.isaqueFilmes.Model.Filme;
import com.gerenciamentoFilmes.isaqueFilmes.Model.FilmeGenero;
import com.gerenciamentoFilmes.isaqueFilmes.Model.Genero;
import com.gerenciamentoFilmes.isaqueFilmes.Repository.IFilmesRepository;
import com.gerenciamentoFilmes.isaqueFilmes.Repository.IGeneroRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private IFilmesRepository filmeRepository;

    @Autowired
    private IGeneroRepository generoRepository;


    public Filme criarFilme(@NotNull FilmeDTO filmeDTO) {
        //Criar instÃ¢ncia da entidade filme
        Filme filme = new Filme();

        //define o nome do filme com base no DTO recebido
        filme.setNomeFilme(filmeDTO.nomeFilme());
        //Define o ano de lanÃ§amento do filme com base no DTO
        filme.setAnoLancamentoFilme(filmeDTO.anoLancamentoFilme());

        Filme filmeSalvo = filmeRepository.save(filme);

        for (Long idGenero : filmeDTO.generoIds()) {

            Genero genero = generoRepository.findById(idGenero)
                    .orElseThrow(() -> new EntityNotFoundException("GÃªnero com Id " + idGenero + " NÃ£o foi encontrado!"));

            //Criar uma nova instÃ¢ncia da entidade que estÃ¡ associada a filme
            FilmeGenero filmeGenero = new FilmeGenero();

            //Define o filme associado
            filmeGenero.setFilme(filmeSalvo);

            //Define o genero associado
            filmeGenero.setGenero(genero);

            //Salvar a associaÃ§Ã£o Ã  lista de gÃªneros de filmes
            filmeSalvo.getGeneros().add(filmeGenero);
        }

        return filmeRepository.save(filmeSalvo);
    }

    public List<FilmeResponseDTO> listarTodosFilmes() {
        return filmeRepository.findAll().stream()
                .map(filme -> {
                    List<String> nomesGeneros = filme.getGeneros().stream()
                            .map(filmeGenero -> filmeGenero.getGenero().getNomeGenero()).toList();

                    return new FilmeResponseDTO(
                            filme.getIdFilme(),
                            filme.getNomeFilme(),
                            filme.getAnoLancamentoFilme(),
                            nomesGeneros
                    );
                }).toList();
    }

    public void deletarFilme(long idFilme) {
        Filme filmeEncontrado = filmeRepository.findById(idFilme)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum filme foi encontrado!"));

        filmeRepository.delete(filmeEncontrado);
    }

    public Filme editarFilme(FilmeDTO filmeDTO) {
        Filme filmeEncontrado = filmeRepository.findById(filmeDTO.idFilme())
                .orElseThrow(() -> new EntityNotFoundException("Filme não foi encontrado!"));

        filmeEncontrado.setNomeFilme(filmeDTO.nomeFilme());
        filmeEncontrado.setAnoLancamentoFilme(filmeDTO.anoLancamentoFilme());

        filmeEncontrado.getGeneros().clear();

        List<FilmeGenero> novosGeneros = new ArrayList<>();

        for (Long idGenero : filmeDTO.generoIds()) {
            Genero genero = generoRepository.findById(idGenero)
                    .orElseThrow(() -> new EntityNotFoundException("Genero não encontrado!"));

            FilmeGenero novoFG = new FilmeGenero();
            novoFG.setFilme(filmeEncontrado);
            novoFG.setGenero(genero);

            novosGeneros.add(novoFG);
        }

        filmeEncontrado.getGeneros().addAll(novosGeneros);

        return filmeRepository.save(filmeEncontrado);
    }

    public Filme buscarFilmePorId(long idFilme) {
        return filmeRepository.findById(idFilme)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum filme foi encotrado!"));
    }

}
