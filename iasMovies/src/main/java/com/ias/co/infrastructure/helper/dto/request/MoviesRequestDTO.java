package com.ias.co.infrastructure.helper.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MoviesRequestDTO {

    private Integer id;
    private String title;
    private String description;
    private Integer duration;
    private Integer punctuation;
    private Integer categoryId;

}
