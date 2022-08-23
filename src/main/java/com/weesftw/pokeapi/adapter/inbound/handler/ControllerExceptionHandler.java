package com.weesftw.pokeapi.adapter.inbound.handler;

import com.weesftw.pokeapi.adapter.inbound.response.ExceptionResponse;
import com.weesftw.pokeapi.adapter.inbound.response.Response;
import com.weesftw.pokeapi.application.entity.exception.HighlightInvalidParamsException;
import com.weesftw.pokeapi.application.entity.exception.PokemonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler
{
    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<Response> handlePokemonNotFoundException()
    {
        return new ResponseEntity<>(new ExceptionResponse("Pokemon not found."), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HighlightInvalidParamsException.class)
    public ResponseEntity<Response> handleHighlightInvalidParamsException()
    {
        return new ResponseEntity<>(new ExceptionResponse("Can't create highlight pokemon: query length must to 2 letter."),
                HttpStatus.BAD_REQUEST);
    }
}