package com.weesftw.pokeapi.application.port;

import com.weesftw.pokeapi.application.entity.PokeAPI;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository
{
    Optional<PokeAPI> findAll();
    Optional<List<String>> getAllNames();
    Optional<List<String>> findByName(String query);
}
