package com.gerenciamentoFilmes.isaqueFilmes.Repository;

import com.gerenciamentoFilmes.isaqueFilmes.Model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFilmesRepository extends JpaRepository<Filme, Long> {
}
