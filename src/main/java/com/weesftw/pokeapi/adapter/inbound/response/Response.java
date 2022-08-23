package com.weesftw.pokeapi.adapter.inbound.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class Response 
{
	protected final LocalDateTime time;
	
	public Response()
	{
		this.time = LocalDateTime.now();
	}
}
