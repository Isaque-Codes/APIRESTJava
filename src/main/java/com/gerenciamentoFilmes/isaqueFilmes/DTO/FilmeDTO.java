package com.gerenciamentoFilmes.isaqueFilmes.DTO;

import java.util.List;

public record FilmeDTO(
        long idFilme,
        String nomeFilme,
        Integer anoLancamentoFilme,
        List<Long> generoIds
) {
}
