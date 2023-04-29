package Pedrodev083.sistemapanitoniback.controller;

import Pedrodev083.sistemapanitoniback.content.movie.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @PostMapping
    @Transactional
    public void add(@RequestBody @Valid DataAddMovie data){
        repository.save(new Movie(data));
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
