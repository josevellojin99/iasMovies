package com.ias.co.infrastructure.helper.entity;

import com.ias.co.domain.model.Categories;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MoviesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Integer duration;
    private Integer punctuation;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private CategoriesEntity categoryId;
}
