package com.exercise.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RickMortyInfos {
  private long count;
  private long pages;
  private String next, previous;
  //private List<RickMortyCharacter> rickMortyCharacters;
}
