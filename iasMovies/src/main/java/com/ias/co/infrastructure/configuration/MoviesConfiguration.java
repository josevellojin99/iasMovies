package com.ias.co.infrastructure.configuration;

import com.ias.co.application.output.MoviesUseCaseRepository;
import com.ias.co.application.usecase.MoviesUseCase;
import com.ias.co.infrastructure.adapter.MoviesRestConsumer;
import com.ias.co.infrastructure.adapter.output.MoviesRepository;
import com.ias.co.infrastructure.helper.mapper.MoviesMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MoviesConfiguration {

    @Bean
    public MoviesUseCase moviesUseCase(MoviesUseCaseRepository moviesUseCaseRepository)
    {
        return new MoviesUseCase(moviesUseCaseRepository);
    }

    @Bean
    public MoviesRestConsumer moviesRestConsumer(MoviesRepository moviesUseCaseRepository, MoviesMapper moviesMapper)
    {
        return new MoviesRestConsumer(moviesUseCaseRepository, moviesMapper);
    }
}
