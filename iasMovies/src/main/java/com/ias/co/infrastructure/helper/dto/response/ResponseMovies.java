package com.ias.co.infrastructure.helper.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseMovies {

    private List<MoviesResponseDTO> data;
    private String status;
    private String message;
}
