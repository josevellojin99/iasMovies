package com.ias.co.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Categories {
    private Integer id;
    private String name;
}
