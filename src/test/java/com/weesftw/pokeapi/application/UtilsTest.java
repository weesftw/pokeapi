package com.weesftw.pokeapi.application;

import com.weesftw.pokeapi.adapter.inbound.response.HighlightResponse;
import com.weesftw.pokeapi.adapter.inbound.response.PokemonResponse;
import com.weesftw.pokeapi.adapter.inbound.response.Response;
import com.weesftw.pokeapi.application.entity.PokeAPI;
import com.weesftw.pokeapi.application.entity.Pokemon;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class UtilsTest
{
    public static PokeAPI getPokeAPI()
    {
        return new PokeAPI(List.of(new Pokemon("bulbasaur", "url"),
                new Pokemon("ivysaur", "url"),
                new Pokemon("venusaur", "url")));
    }

    public static List<String> getAllPokemons()
    {
        List<String> arr = new ArrayList<>();
        arr.add("bulbasaur");
        arr.add("ivysaur");
        arr.add("venusaur");

        return arr;
    }

    public static List<String> getAllPokemonsOrderByAsc()
    {
        List<String> arr = new ArrayList<>();
        arr.add("abomasnow");
        arr.add("abra");
        arr.add("absol");

        return arr;
    }

    public static List<String> getAllPokemonsOrderByLength()
    {
        List<String> arr = new ArrayList<>();
        arr.add("muk");
        arr.add("mew");
        arr.add("abra");

        return arr;
    }

    public static List<String> getAllPokemonsStartWith()
    {
        List<String> arr = new ArrayList<>();
        arr.add("pidgey");
        arr.add("pidgeotto");
        arr.add("pidgeot");

        return arr;
    }

    public static String getHighlightPokemon()
    {
        return "pikachu";
    }

    public static ResponseEntity<Response> getPokemonHighlightResponse()
    {
        return ResponseEntity.ok(new HighlightResponse("pi", "pikachu"));
    }

    public static ResponseEntity<Response> getAllPokemonsResponse()
    {
        return ResponseEntity.ok(new PokemonResponse(getAllPokemons()));
    }

    public static ResponseEntity<Response> getAllPokemonsAscResponse()
    {
        return ResponseEntity.ok(new PokemonResponse(getAllPokemonsOrderByAsc()));
    }

    public static ResponseEntity<Response> getAllPokemonsLengthResponse()
    {
        return ResponseEntity.ok(new PokemonResponse(getAllPokemonsOrderByLength()));
    }
}