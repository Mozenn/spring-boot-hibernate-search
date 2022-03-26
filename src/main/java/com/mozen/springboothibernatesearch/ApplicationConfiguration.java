package com.mozen.springboothibernatesearch;

import com.mozen.springboothibernatesearch.repository.SearchRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(repositoryBaseClass = SearchRepositoryImpl.class)
public class ApplicationConfiguration {
}
