package com.weesftw.pokeapi.adapter.inbound.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(value = "time")
public class HighlightResponse extends Response
{
	private String name;
	private String highlight;
	private final Integer start = 0;
	private Integer end;
	
	public HighlightResponse(String params, String name)
	{
		this.name = name;
		this.highlight = mount(params, name);
		this.end = params.length();
	}

	private String mount(String params, String name)
	{
		return "<pre>" + params + "</pre>" + name.substring(params.length(), name.length());
	}
}
