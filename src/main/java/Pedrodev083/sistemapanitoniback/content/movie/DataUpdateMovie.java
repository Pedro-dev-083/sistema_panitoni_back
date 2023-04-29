package Pedrodev083.sistemapanitoniback.content.movie;

import Pedrodev083.sistemapanitoniback.content.Type;
import jakarta.validation.constraints.NotNull;

public record DataUpdateMovie(
        @NotNull
        Long id,
        String nome,
        Type genero,
        Integer ano
) {
}
