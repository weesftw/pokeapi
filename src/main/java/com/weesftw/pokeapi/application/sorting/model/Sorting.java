package com.weesftw.pokeapi.application.sorting.model;

import java.util.List;

public interface Sorting
{
    void byLength(List<String> args);
    void byLexicographical(List<String> args);
}
