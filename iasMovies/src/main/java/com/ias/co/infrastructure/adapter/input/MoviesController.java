package com.ias.co.infrastructure.adapter.input;

import com.ias.co.application.input.MoviesUseCaseInterface;
import com.ias.co.infrastructure.helper.builder.MoviesBuilder;
import com.ias.co.infrastructure.helper.dto.request.MoviesRequestDTO;
import com.ias.co.infrastructure.helper.dto.response.MoviesResponseDTO;
import com.ias.co.infrastructure.helper.dto.response.ResponseMovies;
import com.ias.co.infrastructure.helper.mapper.MoviesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MoviesController {

    private final MoviesUseCaseInterface moviesUseCaseInterface;

    private final MoviesMapper moviesMapper;

    @PostMapping("/save")
    public Mono<ResponseEntity<ResponseMovies>> save(@RequestBody MoviesRequestDTO moviesRequestDTO)
    {
        return moviesUseCaseInterface.save(MoviesBuilder.toDomain(moviesRequestDTO))
                .flatMap(MoviesBuilder::responseMoviesMono)
                .map(response -> new ResponseEntity<>(
                        MoviesBuilder.responseMoviesMonoDto(response, "200", "Respuesta Ok"),
                        HttpStatus.OK))
                .doOnError(e -> new ResponseEntity<>(
                        MoviesBuilder.responseMoviesMonoDto(null, "404", e.getMessage()),
                        HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ResponseMovies>> getFindById(@PathVariable Integer id)
    {
        return moviesUseCaseInterface.getFinById(id)
                .flatMap(MoviesBuilder::responseMoviesMono)
                .map(response -> new ResponseEntity<>(
                        MoviesBuilder.responseMoviesMonoDto(response, "200", "Respuesta Ok"),
                        HttpStatus.OK))
        .doOnError(e -> new ResponseEntity<>(
            MoviesBuilder.responseMoviesMonoDto(null, "404", e.getMessage()),
            HttpStatus.NOT_FOUND));
    }

    /*@GetMapping("/{value}")
    public Mono<ResponseEntity<ResponseMovies>> getFindByCount(@PathVariable Integer value)
    {
        return moviesUseCaseInterface.getAllFinByCount(value)
                .map(response -> new ResponseEntity<>(
                        MoviesBuilder.responseMoviesMonoDtoList(response, "200", "Respuesta Ok"),
                        HttpStatus.OK))
                .doOnError(e -> new ResponseEntity<>(
                        MoviesBuilder.responseMoviesMonoDto(null, "404", e.getMessage()),
                        HttpStatus.NOT_FOUND));
    }*/
}
