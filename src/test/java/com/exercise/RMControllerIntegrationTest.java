package com.exercise;

import com.exercise.routes.Routes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
class RMControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  private static final String BASE_URL = "http://localhost:8089";

  @Test
  void testRMHttpStatusOK() throws Exception {

    this.mockMvc
        .perform(
            MockMvcRequestBuilders
                .get(BASE_URL + Routes.Version.V1 + "/TestRM")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();
  }

  @Test
  void getCharacterById_OK() throws Exception {
    String characterIdPath = "/1";

    this.mockMvc.perform(
        MockMvcRequestBuilders
            .get(BASE_URL + Routes.Version.V1
                + Routes.RMPath.CHARACTERS + Routes.RMPath.ID + characterIdPath)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }
}

