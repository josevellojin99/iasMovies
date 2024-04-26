package com.ias.co.infrastructure.adapter;

import com.ias.co.application.output.MoviesUseCaseRepository;
import com.ias.co.domain.model.Movies;
import com.ias.co.infrastructure.adapter.output.MoviesRepository;
import com.ias.co.infrastructure.helper.builder.MoviesBuilder;
import com.ias.co.infrastructure.helper.mapper.MoviesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MoviesRestConsumer implements MoviesUseCaseRepository {

    private final MoviesRepository moviesRepository;

    private final MoviesMapper moviesMapper;
    @Override
    public Mono<List<Movies>> getAllFinByCount(Integer count) {
        return null;
    }

    @Override
    public Mono<Movies> getFinById(Integer id) {
        return MoviesBuilder.builderToEntityFinById(moviesRepository.findById(id));
    }

    @Override
    public Mono<Movies> save(Movies movies) {
        return MoviesBuilder.builderToEntity(moviesRepository.save(MoviesBuilder.toEntity(movies)));
    }
}
