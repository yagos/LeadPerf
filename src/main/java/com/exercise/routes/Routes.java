package com.exercise.routes;

public final class Routes {
  private Routes() {
  }

  public static final class Version {
    public static final String V1 = "/v1";
  }

  public static final class RMPath {
    public static final String CHARACTERS = "/characters";
    public static final String ID = "/id";
    public static final String NAME = "/name";
  }

  public static final class RMParam {
    public static final String CHARACTER_ID = "characterId";
    public static final String CHARACTER_NAME = "characterName";
  }

  /********************************/
  /** Rick & Morty - DEFAULT API **/
  /********************************/
  // Rick & Morty - DEFAULT API - URL
  public static final class RickMorty {
    public static final String BASE_URL = "http://rickandmortyapi.com/api";
    public static final String CHARACTER = "/character";

  }

  // Rick & Morty - DEFAULT API - PARAM
  public static final class RickMortyParam {
    public static final String PAGE = "page";
    public static final String NAME = "name";
    public static final String ID = "id";

  }

}
