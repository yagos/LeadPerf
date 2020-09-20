package com.exercise.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RickMortyCharactersInfos {
  public RickMortyInfos info;
  public List<RickMortyCharacter> results;
}
