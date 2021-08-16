package com.weesftw.pokeapi.adapter.outbound.repository;

import com.weesftw.pokeapi.adapter.outbound.persistence.SpringFeignPokemonRepository;
import com.weesftw.pokeapi.application.entity.PokeAPI;
import com.weesftw.pokeapi.application.port.PokemonRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FeignPokemonRepository implements PokemonRepository
{
    private final SpringFeignPokemonRepository pokemonRepository;

    @Override
    public Optional<PokeAPI> findAll()
    {
        return pokemonRepository.getPokemons();
    }

    @Override
    public Optional<List<String>> getAllNames()
    {
        return Optional.of(findAll().get().results().stream().map(x -> x.name()).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<String>> findByName(String query)
    {
        return Optional.of(getAllNames().get().stream()
                .filter(x -> x.startsWith(query != null ? query : Strings.EMPTY))
                .collect(Collectors.toList()));
    }
}
