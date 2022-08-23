package com.weesftw.pokeapi.adapter.outbound.persistence;

import com.weesftw.pokeapi.application.entity.PokeAPI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@FeignClient(name = "PokeAPI", url = "${pokeapi.baseurl}")
public interface SpringFeignPokemonRepository
{
    @GetMapping
    Optional<PokeAPI> getPokemons();
}
