package com.exercise.service;

import com.exercise.model.RickMortyCharacter;
import com.exercise.model.RickMortyCharactersInfos;
import com.exercise.routes.Routes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class RickMortyService {

  private final WebClient webClient =
      WebClient.builder()
          .baseUrl(Routes.RickMorty.BASE_URL)
          .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE, MediaType.ALL_VALUE)
          .build();

  public Mono<RickMortyCharactersInfos> getCharacters() {
    log.debug("Launching getCharacters.");

    return webClient
        .get()
        .uri(Routes.RickMorty.CHARACTER.concat("/?"+Routes.RickMortyParam.PAGE+"=1"))
        .accept(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML)
        .retrieve()
        .bodyToMono(RickMortyCharactersInfos.class);
  }

  /*
  public Mono<RickMortyCharacter> getCharacterById(long characterId) {
    log.debug("Launching getCharacterById with character id: {}", characterId);

    return webClient
        .get()
        .uri(Routes.RickMorty.CHARACTER.concat("/{ }"), characterId)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(RickMortyCharacter.class);
  }
  */

  public Mono<RickMortyCharactersInfos> getCharacterByName(String characterName) {
    log.debug("Launching getCharacterByName with character name: {}", characterName);

    return webClient
        .get()
        .uri(Routes.RickMorty.CHARACTER.concat("/?"+ Routes.RickMortyParam.NAME +"={ }"), characterName)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(RickMortyCharactersInfos.class);
  }
}
