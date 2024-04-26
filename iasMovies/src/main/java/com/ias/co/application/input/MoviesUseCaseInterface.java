package com.ias.co.application.input;

import com.ias.co.domain.model.Movies;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MoviesUseCaseInterface {

    Mono<List<Movies>> getAllFinByCount(Integer count);

    Mono<Movies> getFinById(Integer id);

    Mono<Movies> save(Movies movies);
}
