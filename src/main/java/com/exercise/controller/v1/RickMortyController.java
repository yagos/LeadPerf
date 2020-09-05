package com.exercise.controller.v1;

import com.exercise.model.RickMortyCharacter;
import com.exercise.model.RickMortyCharactersInfos;
import com.exercise.routes.Routes;
import com.exercise.service.RickMortyService;
import com.sun.istack.NotNull;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@Api("Rick&Morty")
@Slf4j
@RequestMapping(path = Routes.Version.V1)
public class RickMortyController {

  private static final Logger LOGGER = LoggerFactory.getLogger(RickMortyController.class);

  @Autowired
  private RickMortyService rickMortyService;


  @GetMapping(value = "/TestRM")
  @ApiOperation(value = "Get a test value")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Test has been executed."),
      @ApiResponse(code = 500, message = "Internal server error.")})
  public String test() {
    log.debug("Test route is executed.");
    return "This is a TEST !";
  }

  @GetMapping(value = Routes.RMPath.CHARACTERS)
  @ApiOperation(value = "Get all characters.")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Get all characters."),
      @ApiResponse(code = 500, message = "Internal server error.")})
  public Mono<RickMortyCharactersInfos> getAllCharacters(
  ) {
    Mono<RickMortyCharactersInfos> rickMortyCharactersInfos = rickMortyService.getCharacters();
    log.debug("Got following response: {}", rickMortyCharactersInfos);
    return rickMortyCharactersInfos;
  }

  @GetMapping(value = Routes.RMPath.CHARACTERS + Routes.RMPath.ID
      + "/{" + Routes.RMParam.CHARACTER_ID + "}")
  @ApiOperation(value = "Get character by id.")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Get character by id."),
      @ApiResponse(code = 500, message = "Internal server error.")})
  public Mono<RickMortyCharacter> getCharacterByid(
      @ApiParam(value = "Id of the character.", required = true)
      @PathVariable(Routes.RMParam.CHARACTER_ID) @NotNull @Valid long characterId
  ) {
    log.debug("Path param char id: {}", characterId);
    Mono<RickMortyCharacter> rickMortyCharacter = rickMortyService.getCharacterById(characterId);
    log.debug("Got following response: {}", rickMortyCharacter);

    return rickMortyCharacter;
  }

  @GetMapping(value = Routes.RMPath.CHARACTERS + Routes.RMPath.NAME
      + "/{" + Routes.RMParam.CHARACTER_NAME + "}")
  @ApiOperation(value = "Get character by name.")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Character name."),
      @ApiResponse(code = 500, message = "Internal server error.")})
  public Mono<RickMortyCharactersInfos> getCharactersByName(
      @ApiParam(value = "Character name.", required = true)
      @PathVariable(Routes.RMParam.CHARACTER_NAME) @NotNull @Valid String characterName
  ) {
    log.debug("Path param character name: {}", characterName);
    Mono<RickMortyCharactersInfos> rickMortyCharactersInfos = rickMortyService.getCharacterByName(characterName);
    log.debug("Got following response: {}", rickMortyCharactersInfos);

    return rickMortyCharactersInfos;
  }

  // DELETE + POST - It's not handled by the RM API
  @DeleteMapping(value = Routes.RMPath.CHARACTERS + Routes.RMPath.ID
      + "/{" + Routes.RMParam.CHARACTER_ID + "}")
  @ApiOperation(value = "Delete character by id.")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Character id."),
      @ApiResponse(code = 500, message = "Internal server error.")})
  public Mono<RickMortyCharactersInfos> deleteCharactersById(
      @ApiParam(value = "Character id.", required = true)
      @PathVariable(Routes.RMParam.CHARACTER_ID) @NotNull @Valid String characterId
  ) {
    log.debug("Path param character id: {}", characterId);
    Mono<RickMortyCharactersInfos> rickMortyCharactersInfos = rickMortyService.deleteCharacterById(characterId);
    log.debug("Got following response: {}", rickMortyCharactersInfos);

    return rickMortyCharactersInfos;
  }

  // DELETE + POST - It's not handled by the RM API
  @PostMapping(value = Routes.RMPath.CHARACTERS)
  @ApiOperation(value = "Create character.")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Character id."),
      @ApiResponse(code = 500, message = "Internal server error.")})
  public Mono<RickMortyCharactersInfos> createCharacter(
      @ApiParam(value = "Character id.", required = true)
      @RequestParam("character") @NotNull @Valid RickMortyCharacter rickMortyCharacter
  ) {
    log.debug("Body param character: {}", rickMortyCharacter);
    Mono<RickMortyCharactersInfos> rickMortyCharactersInfos = rickMortyService.createCharacter(rickMortyCharacter);
    log.debug("Got following response: {}", rickMortyCharactersInfos);

    return rickMortyCharactersInfos;
  }

}

