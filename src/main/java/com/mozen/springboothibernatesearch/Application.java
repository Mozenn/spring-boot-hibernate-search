package com.mozen.springboothibernatesearch;

import com.mozen.springboothibernatesearch.index.Indexer;
import com.mozen.springboothibernatesearch.model.Plant;
import com.mozen.springboothibernatesearch.repository.PlantRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ApplicationRunner initializeData(PlantRepository plantRepository) throws Exception {
		return (ApplicationArguments args) -> {
			List<Plant> plants = Arrays.asList(
					new Plant("subalpine fir", "abies lasiocarpa", "pinaceae"),
					new Plant("sour cherry", "prunus cerasus", "rosaceae"),
					new Plant("asian pear", "pyrus pyrifolia", "rosaceae"),
					new Plant("chinese witch hazel", "hamamelis mollis", "hamamelidaceae"),
					new Plant("silver maple", "acer saccharinum", "sapindaceae"),
					new Plant("cucumber tree", "magnolia acuminata", "magnoliaceae"),
					new Plant("korean rhododendron", "rhododendron mucronulatum", "ericaceae"),
					new Plant("water lettuce", "pistia", "araceae"),
					new Plant("sessile oak", "quercus petraea", "fagaceae"),
					new Plant("common fig", "ficus carica", "moraceae")
			);
			plantRepository.saveAll(plants);
		};
	}

	@Bean
	public ApplicationRunner buildIndex(Indexer indexer) {
		return (ApplicationArguments args) -> {
			indexer.indexPersistedData("com.mozen.springboothibernatesearch.model.Plant");
		};
	}
}
