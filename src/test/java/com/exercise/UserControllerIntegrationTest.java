package com.exercise;

import com.exercise.routes.Routes;
import org.hamcrest.core.Is;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
class UserControllerIntegrationTest {

  @Autowired
  private MockMvc mvc;

  private static final String BASE_URL = "http://localhost:8089";

  @Test
  void userProfileLegacyHttpStatusOK() throws Exception {

    this.mvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/" + Routes.Version.V1 + "/TestRM")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void userProfileLegacyContentOK() throws Exception {
    final String expectedResult = "<results></results>";

    this.mvc.perform(MockMvcRequestBuilders.get(BASE_URL)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("", Is.is(expectedResult)));
  }
}

