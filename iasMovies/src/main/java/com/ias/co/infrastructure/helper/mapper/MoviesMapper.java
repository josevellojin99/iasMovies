package com.ias.co.infrastructure.helper.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.ias.co.domain.model.Movies;
import com.ias.co.infrastructure.helper.dto.request.MoviesRequestDTO;
import com.ias.co.infrastructure.helper.dto.response.MoviesResponseDTO;
import com.ias.co.infrastructure.helper.entity.MoviesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface MoviesMapper {

    MoviesResponseDTO toMoviesResponseDTo(Movies movies);

    Movies toDomain(MoviesRequestDTO movies);

    List<MoviesResponseDTO> map(List<Movies> moviesList);

}
