package com.weesftw.pokeapi.adapter.inbound.response;

import lombok.Data;

@Data
public class ExceptionResponse extends Response
{
	private final String message;
	
	public ExceptionResponse(String msg)
	{
		this.message = msg;
	}
}
