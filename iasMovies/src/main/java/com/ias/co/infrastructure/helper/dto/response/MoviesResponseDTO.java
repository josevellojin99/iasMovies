package com.ias.co.infrastructure.helper.dto.response;

import com.ias.co.domain.model.Categories;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MoviesResponseDTO{

    private Integer id;
    private String title;
    private String description;
    private Integer duration;
    private Integer punctuation;
    private Integer categoryId;
}
