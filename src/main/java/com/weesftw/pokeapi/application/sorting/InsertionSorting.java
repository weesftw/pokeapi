package com.weesftw.pokeapi.application.sorting;

import com.weesftw.pokeapi.application.sorting.model.Sorting;

import java.util.List;

/**
 * <ul>
 * <li>Insertion Sort is stable.</li>
 * <li>Worst case: O(n²)</li>
 * <li>Worst case space: O(n)</li>
 * </ul>
 * <p>
 * <b>Big-O é baseado em dois fatores</b>:
 * <ol>
 * <li>Buscar por lacos de repeticoes, ex: for, while...</li>
 * <li>Ignorar constantes O(1) e calcular os fatores de maior complexidade.</li>
 * </ol>
 * <p>
 * <p>
 * No caso do <b>Insertion Sort</b>, temos dois lacos um dentro do outro e ambas dependem de uma variacão
 * vulgo (n), sendo assim, seguindo os passos descritos acima temos: <b>O(n) + O(n) = O(n²)</b>.<p>
 * No pior cenário, se eu tiver um array de mil elementos, ele será iterado um milhão de vezes,
 * porém, dentro do contexto da aplicacão e por ser um algoritmo simples, ele vai nos atender
 * melhor em comparacão ao Bubble e Selection.
 */
public class InsertionSorting implements Sorting
{
    @Override
    public void byLength(List<String> args)
    {
        /*
         * A complexidade dos metodos da class ArrayList do Java foram consultadas no Javadocs.
         *
         * "The size, isEmpty, get, set, iterator, and listIterator operations run in constant time."
         * href: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
         */
        if(args != null)
        {
            for(int i = 1; i < args.size(); i++) // O(n)
            {
                String key = args.get(i); // O(1)
                int j = i - 1; // O(1)

                /*
                 * Checks:
                 *      1. Se (j) é maior ou igual a 0
                 *      2. Se key length é menor que a string (j) length
                 *
                 * Se ambas se validarem, swap.
                 */
                while(j >= 0 && key.length() < args.get(j).length()) // O(n)
                {
                    args.remove(j + 1); // O(1)
                    args.add(j + 1, args.get(j)); // O(1)

                    j--; // O(1)
                }

                args.remove(j + 1); // O(1)
                args.add(j + 1, key); // O(1)
            }
        }
    }

    @Override
    public void byLexicographical(List<String> args)
    {
        if (args != null)
        {
            for (int i = 1; i < args.size(); i++)
            {
                String key = args.get(i);
                int j = i - 1;

                while (j >= 0)
                {
                    if (key.compareTo(args.get(j)) > 0)
                    {
                        break;
                    }

                    args.remove(j + 1);
                    args.add(j + 1, args.get(j));

                    j--;
                }

                args.remove(j + 1);
                args.add(j + 1, key);
            }
        }
    }
}
