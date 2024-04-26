package com.ias.co.infrastructure.helper.builder;

import com.ias.co.domain.model.Categories;
import com.ias.co.domain.model.Movies;
import com.ias.co.infrastructure.helper.dto.request.MoviesRequestDTO;
import com.ias.co.infrastructure.helper.dto.response.MoviesResponseDTO;
import com.ias.co.infrastructure.helper.dto.response.ResponseMovies;
import com.ias.co.infrastructure.helper.entity.CategoriesEntity;
import com.ias.co.infrastructure.helper.entity.MoviesEntity;
import lombok.experimental.UtilityClass;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UtilityClass
public class MoviesBuilder {

    public Mono<MoviesResponseDTO> responseMoviesMono(Movies movies)
    {
        return Mono.just(MoviesResponseDTO.builder()
                .title(movies.getTitle())
                .description(movies.getDescription())
                .duration(movies.getDuration())
                .categoryId(movies.getCategoryId())
                .punctuation(movies.getPunctuation())
                .build());
    }

    public ResponseMovies responseMoviesMonoDto(MoviesResponseDTO moviesList, String message, String code)
    {
        List<MoviesResponseDTO> moviesResponseDTOS = new ArrayList<>();
        moviesResponseDTOS.add(moviesList);
        return ResponseMovies.builder()
                .data(moviesResponseDTOS)
                .message(message)
                .status(code)
                .build();
    }

    public Mono<Movies> builderToEntity(MoviesEntity movies)
    {
        Categories categories = Categories
                .builder().id(movies.getCategoryId().getCategoryId())
                .name(movies.getCategoryId().getName())
                .build();
        return Mono.just(Movies.builder()
                .title(movies.getTitle())
                .description(movies.getDescription())
                .duration(movies.getDuration())
                .categoryId(categories.getId())
                .punctuation(movies.getPunctuation())
                .build());
    }

    public Mono<Movies> builderToEntityFinById(Optional<MoviesEntity> movies)
    {
        Categories categories = Categories
                .builder().id(movies.get().getCategoryId().getCategoryId())
                .name(movies.get().getCategoryId().getName())
                .build();
        return Mono.justOrEmpty(Movies.builder()
                .title(movies.get().getTitle())
                .description(movies.get().getDescription())
                .duration(movies.get().getDuration())
                .categoryId(movies.get().getCategoryId().getCategoryId())
                .punctuation(movies.get().getPunctuation())
                .build());
    }

    public Movies toDomain(MoviesRequestDTO movies)
    {

        Categories categories = Categories
                .builder().id(movies.getCategoryId())
                .build();
        return Movies.builder()
                .title(movies.getTitle())
            .description(movies.getDescription())
            .duration(movies.getDuration())
            .categoryId(categories.getId())
            .punctuation(movies.getPunctuation())
            .build();
    }

    public MoviesEntity toEntity(Movies movies) {
        if ( movies == null ) {
            return null;
        }

        MoviesEntity moviesEntity = new MoviesEntity();



        CategoriesEntity categories = new CategoriesEntity();
        categories.setCategoryId(movies.getCategoryId() );


        moviesEntity.setId( movies.getId() );
        moviesEntity.setTitle( movies.getTitle() );
        moviesEntity.setDescription( movies.getDescription() );
        moviesEntity.setDuration( movies.getDuration() );
        moviesEntity.setPunctuation( movies.getPunctuation() );
        moviesEntity.setCategoryId(categories );

        return moviesEntity;
    }





}
