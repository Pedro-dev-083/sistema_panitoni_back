package Pedrodev083.sistemapanitoniback.content.movie;

import Pedrodev083.sistemapanitoniback.content.Type;

public record DataListMovie(
        Long id,
        String nome,
        Type genero,
        Integer ano
) {
    public DataListMovie(Movie movie){
        this(movie.getId(), movie.getNome(), movie.getGenero(), movie.getAno());
    }
}
