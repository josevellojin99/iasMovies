package com.ias.co.infrastructure.adapter.output;

import com.ias.co.infrastructure.helper.entity.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<MoviesEntity, Integer> {
}
