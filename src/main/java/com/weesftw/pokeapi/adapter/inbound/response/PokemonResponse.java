package com.weesftw.pokeapi.adapter.inbound.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(value = "time")
public class PokemonResponse extends Response
{
	private List<String> result;
	
	public PokemonResponse(List<String> pokemons)
	{
		this.result = pokemons;
	}
}
