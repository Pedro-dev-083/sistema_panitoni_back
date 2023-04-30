package Pedrodev083.sistemapanitoniback.controller;

import Pedrodev083.sistemapanitoniback.content.movie.*;
import Pedrodev083.sistemapanitoniback.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ApiResponse> add(@RequestBody @Valid DataAddMovie data){
        try{
            repository.save(new Movie(data));
            String message = String.format("O filme %s foi adicionado com sucesso.", data.nome());
            return ResponseEntity.ok(new ApiResponse(true, message));
        } catch (Exception e){
            System.out.println("caiu aqui");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, e.getMessage()));
        }
    }

    @GetMapping
    public Page<DataListMovie> list(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        return repository.findAll(paginacao).map(DataListMovie::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataUpdateMovie data){
        var movie = repository.getReferenceById(data.id());
        movie.updateInfo(data);
    }
}
