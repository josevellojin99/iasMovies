package com.ias.co.application.usecase;

import com.ias.co.application.input.CategoriesUseCaseInterface;
import com.ias.co.application.input.MoviesUseCaseInterface;
import com.ias.co.application.output.MoviesUseCaseRepository;
import com.ias.co.domain.model.Movies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoviesUseCase implements MoviesUseCaseInterface {

    private final MoviesUseCaseRepository moviesUseCaseRepository;

    @Override
    public Mono<List<Movies>> getAllFinByCount(Integer count) {
        return moviesUseCaseRepository.getAllFinByCount(count);
    }

    @Override
    public Mono<Movies> getFinById(Integer id) {
        return moviesUseCaseRepository.getFinById(id);
    }

    @Override
    public Mono<Movies> save(Movies movies) {
        return moviesUseCaseRepository.save(movies);
    }
}
