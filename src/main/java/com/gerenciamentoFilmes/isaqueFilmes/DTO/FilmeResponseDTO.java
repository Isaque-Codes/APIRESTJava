package com.gerenciamentoFilmes.isaqueFilmes.DTO;

import java.util.List;

public record FilmeResponseDTO(
        long idFilme,
        String nomeFilme,
        Integer anoLancamentoFilme,
        List<String> generos
) {
}
