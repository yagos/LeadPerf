package com.exercise.configuration;

import com.exercise.service.RickMortyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SPConfiguration {

  @Bean
  public RickMortyService rmService() {
    return new RickMortyService();
  }
}
