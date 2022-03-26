package com.mozen.springboothibernatesearch.controller;

import com.mozen.springboothibernatesearch.model.Plant;
import com.mozen.springboothibernatesearch.model.SearchRequestDTO;
import com.mozen.springboothibernatesearch.service.PlantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/plant")
public class PlantController {

    private PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/search")
    public List<Plant> searchPlants(SearchRequestDTO searchRequestDTO) {

        log.info("Request for plant search received with data : " + searchRequestDTO);

        return plantService.searchPlants(searchRequestDTO.getText(), searchRequestDTO.getFields(), searchRequestDTO.getLimit());
    }
}
