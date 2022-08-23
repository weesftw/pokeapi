package com.weesftw.pokeapi.application.port;

import com.weesftw.pokeapi.application.entity.exception.HighlightInvalidParamsException;
import com.weesftw.pokeapi.application.entity.exception.PokemonNotFoundException;
import com.weesftw.pokeapi.application.sorting.model.Sort;

import java.util.List;

public interface PokemonService
{
    List<String> getName(String query, Sort sorter) throws PokemonNotFoundException;
    String getHighlight(String query) throws PokemonNotFoundException, HighlightInvalidParamsException;
}
