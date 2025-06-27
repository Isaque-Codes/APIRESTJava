package com.gerenciamentoFilmes.isaqueFilmes.Repository;

import com.gerenciamentoFilmes.isaqueFilmes.Model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGeneroRepository extends JpaRepository<Genero, Long> {
}
