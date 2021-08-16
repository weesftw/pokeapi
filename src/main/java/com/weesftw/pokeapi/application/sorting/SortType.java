package com.weesftw.pokeapi.application.sorting;

import com.weesftw.pokeapi.application.sorting.model.Sort;
import com.weesftw.pokeapi.application.sorting.model.Sorting;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

public enum SortType implements Sort
{
    ASC
            {
                @Override
                public void execute(List<String> args)
                {
                    strategy.byLexicographical(args);
                }
            },
    LENGTH
            {
                @Override
                public void execute(List<String> args)
                {
                    strategy.byLength(args);
                }
            },
    NONE
            {
                @Override
                public void execute(List<String> args)
                {

                }
            };

    @Setter
    Sorting strategy;

    public static SortType get(String args)
    {
        return Arrays.stream(values())
                .filter((x) ->
                {
                    if(args != null)
                    {
                        return x.name().contains(args.toUpperCase());
                    }

                    return false;
                })
                .findFirst()
                .orElse(NONE);
    }

    @Service
    @AllArgsConstructor
    public static class SortTypeInjector
    {
        private Sorting sortStrategy;

        @PostConstruct
        public void postConstruct()
        {
            for(SortType sortType : SortType.values())
                sortType.setStrategy(sortStrategy);
        }
    }
}
