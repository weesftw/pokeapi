package com.weesftw.pokeapi.adapter.inbound.controller;

import com.weesftw.pokeapi.adapter.inbound.handler.AttributeMap;
import com.weesftw.pokeapi.adapter.inbound.response.HighlightResponse;
import com.weesftw.pokeapi.adapter.inbound.response.PokemonResponse;
import com.weesftw.pokeapi.application.UtilsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PokemonControllerTest
{
    @MockBean
    private PokemonController pokemonController;

    @Test
    @DisplayName("Get all pokemons returns list of pokemons when successful")
    public void getAllPokemonsReturnListOfPokemonWhenSuccessful() throws Exception
    {
        AttributeMap map = new AttributeMap();

        when(pokemonController.getPokemons(ArgumentMatchers.any()))
                .thenReturn(UtilsTest.getAllPokemonsResponse());

        PokemonResponse response = (PokemonResponse) pokemonController.getPokemons(map).getBody();

        Assertions.assertThat(response.getResult()).isNotNull();
        Assertions.assertThat(response.getResult().size()).isEqualTo(3);
        Assertions.assertThat(response.getResult().get(0)).isEqualTo("bulbasaur");
    }

    @Test
    @DisplayName("Get highlight pokemon returns one pokemons when successful")
    public void getHighlightPokemonReturnsOnePokemonWhenSuccessful() throws Exception
    {
        AttributeMap map = new AttributeMap();
        map.setQ("pi");
        map.setHighlight("true");

        when(pokemonController.getPokemons(map))
                .thenReturn(UtilsTest.getPokemonHighlightResponse());

        HighlightResponse response = (HighlightResponse) pokemonController.getPokemons(map).getBody();

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getEnd()).isEqualTo(2);
        Assertions.assertThat(response.getName()).isEqualTo("pikachu");
        Assertions.assertThat(response.getHighlight()).startsWith("<pre>");
    }

    @Test
    @DisplayName("Get all pokemons returns list of pokemons order by asc when successful")
    public void getAllPokemonsReturnsListOfPokemonsOrderByAscWhenSuccessful() throws Exception
    {
        AttributeMap map = new AttributeMap();
        map.setOrder("asc");

        when(pokemonController.getPokemons(map))
                .thenReturn(UtilsTest.getAllPokemonsAscResponse());

        PokemonResponse response = (PokemonResponse) pokemonController.getPokemons(map).getBody();

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getResult().get(0)).isEqualTo("abomasnow");
    }

    @Test
    @DisplayName("Get all pokemons returns list of pokemons order by length when successful")
    public void getAllPokemonsReturnsListOfPokemonsOrderByLengthWhenSuccessful() throws Exception
    {
        AttributeMap map = new AttributeMap();
        map.setOrder("length");

        when(pokemonController.getPokemons(map))
                .thenReturn(UtilsTest.getAllPokemonsLengthResponse());

        PokemonResponse response = (PokemonResponse) pokemonController.getPokemons(map).getBody();

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getResult().get(0)).isEqualTo("muk");
    }
}