package com.exercise.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RickMortyCharacter {
  private long id;
  private String name, url, status, species, type, gender, created;
}
