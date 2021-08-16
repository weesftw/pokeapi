package com.weesftw.pokeapi.adapter.inbound.controller;

import com.weesftw.pokeapi.adapter.inbound.handler.AttributeMap;
import com.weesftw.pokeapi.adapter.inbound.response.HighlightResponse;
import com.weesftw.pokeapi.adapter.inbound.response.PokemonResponse;
import com.weesftw.pokeapi.adapter.inbound.response.Response;
import com.weesftw.pokeapi.application.sorting.SortType;
import com.weesftw.pokeapi.application.entity.exception.HighlightInvalidParamsException;
import com.weesftw.pokeapi.application.entity.exception.PokemonNotFoundException;
import com.weesftw.pokeapi.application.port.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pokemons")
@AllArgsConstructor
public class PokemonController
{
    private final PokemonService service;

    @GetMapping
    public ResponseEntity<Response> getPokemons(AttributeMap map) throws PokemonNotFoundException, HighlightInvalidParamsException
    {
        String query = map.getQ();
        SortType orderBy = SortType.get(map.getOrder());
        Boolean isHighlight = Boolean.parseBoolean(map.getHighlight());

        if(query != null)
        {
            if(isHighlight)
            {
                return ResponseEntity.ok(new HighlightResponse(query, service.getHighlight(query)));
            }
        }

        return ResponseEntity.ok(new PokemonResponse(service.getName(query, orderBy)));
    }
}
