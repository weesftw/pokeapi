package com.weesftw.pokeapi.application.service;

import com.weesftw.pokeapi.application.entity.exception.HighlightInvalidParamsException;
import com.weesftw.pokeapi.application.entity.exception.PokemonNotFoundException;
import com.weesftw.pokeapi.application.port.PokemonRepository;
import com.weesftw.pokeapi.application.port.PokemonService;
import com.weesftw.pokeapi.application.sorting.SortType;
import com.weesftw.pokeapi.application.sorting.model.Sort;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@AllArgsConstructor
public class PokemonServiceImpl implements PokemonService
{
    private PokemonRepository pokeRepository;

    @Override
    @Cacheable(cacheNames = "allNames", key = "{#root.methodName, #query, #sorter}")
    public List<String> getName(String query, Sort sorter) throws PokemonNotFoundException
    {
        List<String> result = pokeRepository.findByName(query).get();
        sorter.execute(result);

        if(result.isEmpty())
            throw new PokemonNotFoundException();

        return result;
    }

    @Override
    @Cacheable(cacheNames = "allNames", key = "{#root.methodName, #query}")
    public String getHighlight(String query) throws PokemonNotFoundException, HighlightInvalidParamsException
    {
        List<String> result = getName(query, SortType.ASC);

        if(query.length() != 2)
            throw new HighlightInvalidParamsException();
        else
            return result.get(Math.round(result.size() / 2));
    }
}
