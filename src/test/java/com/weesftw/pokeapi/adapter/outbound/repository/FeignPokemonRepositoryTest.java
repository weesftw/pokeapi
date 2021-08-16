package com.weesftw.pokeapi.adapter.outbound.repository;

import com.weesftw.pokeapi.application.UtilsTest;
import com.weesftw.pokeapi.adapter.outbound.persistence.SpringFeignPokemonRepository;
import com.weesftw.pokeapi.application.entity.PokeAPI;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(SpringExtension.class)
class FeignPokemonRepositoryTest
{
    @InjectMocks
    private FeignPokemonRepository repository;

    @Mock
    private SpringFeignPokemonRepository feign;

    @BeforeEach
    void setUp()
    {
         standaloneSetup(repository)
                 .build();

         when(feign.getPokemons()).thenReturn(Optional.of(UtilsTest.getPokeAPI()));
    }

    @Test
    @DisplayName("Find all return list of pokemons when successful")
    void findAllReturnListOfPokemonsWhenSuccessful()
    {
        Optional<PokeAPI> result = repository.findAll();

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.get().results().get(0).name()).isEqualTo("bulbasaur");
    }

    @Test
    @DisplayName("Get all names returns List of pokemon name when successful")
    void getAllNamesReturnsListOfPokemonsNameWhenSuccessful()
    {
        Optional<List<String>> result = repository.getAllNames();

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.get().get(0)).isEqualTo("bulbasaur");
    }
}