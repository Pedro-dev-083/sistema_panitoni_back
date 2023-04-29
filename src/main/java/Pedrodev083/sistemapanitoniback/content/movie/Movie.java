package Pedrodev083.sistemapanitoniback.content.movie;

import Pedrodev083.sistemapanitoniback.content.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "movies")
@Entity(name = "Movie")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Type genero;
    private Integer ano;

    public Movie(DataAddMovie data){
        this.nome = data.nome();
        this.genero = data.genero();
        this.ano = data.ano();
    }

    public void updateInfo(DataUpdateMovie data){
        if (data.nome() != null){
            this.nome = data.nome();
        }
        if (data.genero() != null){
            this.genero = data.genero();
        }
        if (data.ano() != null){
            this.ano = data.ano();
        }
    }
}
