package com.ias.co.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movies {

    private Integer id;
    private String title;
    private String description;
    private Integer duration;
    private Integer punctuation;
    private Integer categoryId;
}
