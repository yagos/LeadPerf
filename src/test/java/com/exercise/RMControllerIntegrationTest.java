package com.exercise;

import com.exercise.model.RickMortyCharacter;
import com.exercise.routes.Routes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.exercise.controller.v1.RickMortyController.TEST_RESPONSE;

//@RunWith(SpringRunner.class)
@RunWith(JUnitPlatform.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Tag("serverRuns")
class RMControllerIntegrationTest {

  private static final String BASE_URL = "http://localhost:8089";

  WebTestClient webTestClient;

  @BeforeEach
  void setUp() {
    this.webTestClient = WebTestClient
        .bindToServer()
        .baseUrl(BASE_URL + Routes.Version.V1)
        .defaultHeader(MediaType.ALL_VALUE)
        .build();
  }

  @Test
  public void defaultTest() {
    this.webTestClient
        .get()
        .uri("/TestRM")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("[0]").exists()
        .jsonPath("[0]").isEqualTo(TEST_RESPONSE);
  }

  @Test
  public void usersObjectWithId1Test() {
    long expectedId = 1L;
    String expectedName = "Rick Sanchez";
    String expectedUrl = "https://rickandmortyapi.com/api/character/1";
    String expectedStatus = "Alive";
    String expectedSpecies = "Human";
    String expectedGender = "Male";
    String expectedType = "";
    String expectedcreationDate = "2017-11-04T18:48:46.250Z";

    RickMortyCharacter expectedRickMortyCharacter =
        RickMortyCharacter.builder()
            .id(expectedId).name(expectedName).url(expectedUrl).status(expectedStatus)
            .species(expectedSpecies).gender(expectedGender).created(expectedcreationDate)
            .type(expectedType)
            .build();

    this.webTestClient.get().uri("/characters/id/1")
        .exchange()
        .expectStatus().isOk()
        .expectBodyList(RickMortyCharacter.class)
        .hasSize(1)
        .contains(expectedRickMortyCharacter);
  }

  @Test
  public void allUsersTest() {
    int expectedLength = 2;
    int expectedCount = 671;

    this.webTestClient
        .get()
        .uri("/characters")
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(MediaType.APPLICATION_JSON)
        .expectBody()
        .jsonPath("$.length()").isEqualTo(expectedLength)
        .jsonPath("$.info.count").isEqualTo(expectedCount);
  }


}

