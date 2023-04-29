package Pedrodev083.sistemapanitoniback.content.movie;

import Pedrodev083.sistemapanitoniback.content.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataAddMovie(
        @NotBlank
        String nome,
        @NotNull
        Type genero,
        @NotNull
        Integer ano

) {
}
