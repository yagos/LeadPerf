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
  public long id;
  public String name, url, status, species, type, gender, created;
}
