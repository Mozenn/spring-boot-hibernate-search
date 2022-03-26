package com.mozen.springboothibernatesearch.repository;

import com.mozen.springboothibernatesearch.model.Plant;
import org.springframework.stereotype.Repository;


@Repository
public interface PlantRepository extends SearchRepository<Plant, Long> {
}
