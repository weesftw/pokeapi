package com.weesftw.pokeapi.adapter.config;

import com.weesftw.pokeapi.application.port.PokemonRepository;
import com.weesftw.pokeapi.application.port.PokemonService;
import com.weesftw.pokeapi.application.sorting.model.Sorting;
import com.weesftw.pokeapi.application.service.PokemonServiceImpl;
import com.weesftw.pokeapi.application.sorting.InsertionSorting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration
{
    @Bean
    Sorting sortStrategy()
    {
        return new InsertionSorting();
    }

    @Bean
    PokemonService pokemonService(PokemonRepository repository)
    {
        return new PokemonServiceImpl(repository);
    }
}
