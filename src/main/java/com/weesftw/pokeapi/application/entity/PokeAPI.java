package com.weesftw.pokeapi.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PokeAPI(@JsonProperty(value = "results") List<Pokemon> results)
{

}
