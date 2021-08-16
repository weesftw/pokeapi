package com.weesftw.pokeapi.application.service;

import com.weesftw.pokeapi.application.UtilsTest;
import com.weesftw.pokeapi.application.sorting.SortType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class PokemonServiceImplTest
{
    @MockBean
    private PokemonServiceImpl service;

    @Test
    @DisplayName("Get name returns list all pokemons when query params is blank and successful")
    void getNameReturnListAllPokemonsWhenQueryParamsIsBlank() throws Exception
    {
        when(service.getName(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenReturn(UtilsTest.getAllPokemons());

        List<String> result = service.getName(null, null);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(3);
        Assertions.assertThat(result.get(0)).isEqualTo("bulbasaur");
    }

    @Test
    @DisplayName("Get highlight pokemon returns one pokemons")
    void getHighlightPokemonReturnsOnePokemon() throws Exception
    {
        when(service.getHighlight(ArgumentMatchers.eq("pi")))
                .thenReturn(UtilsTest.getHighlightPokemon());

        String result = service.getHighlight("pi");

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isEqualTo("pikachu");
    }

    @Test
    @DisplayName("Get name returns list of pokemons start with")
    void getNameReturnsListOfPokemonsStartWith() throws Exception
    {
        when(service.getName(ArgumentMatchers.eq("pi"), ArgumentMatchers.any()))
                .thenReturn(UtilsTest.getAllPokemonsStartWith());

        List<String> result = service.getName("pi", null);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(3);
        Assertions.assertThat(result.get(0)).isEqualTo("pidgey");
    }

    @Test
    @DisplayName("Get name returns list of pokemons order by asc")
    void getNameReturnsListOfPokemonsOrderByAsc() throws Exception
    {
        when(service.getName(ArgumentMatchers.any(), ArgumentMatchers.eq(SortType.ASC)))
                .thenReturn(UtilsTest.getAllPokemonsOrderByAsc());

        List<String> result = service.getName(null, SortType.ASC);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(3);
        Assertions.assertThat(result.get(0)).isEqualTo("abomasnow");
    }

    @Test
    @DisplayName("Get name returns list of pokemons order by length")
    void getNameReturnsListOfPokemonsOrderByLength() throws Exception
    {
        when(service.getName(ArgumentMatchers.any(), ArgumentMatchers.eq(SortType.LENGTH)))
                .thenReturn(UtilsTest.getAllPokemonsOrderByLength());

        List<String> result = service.getName(null, SortType.LENGTH);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(3);
        Assertions.assertThat(result.get(0)).isEqualTo("muk");
    }
}