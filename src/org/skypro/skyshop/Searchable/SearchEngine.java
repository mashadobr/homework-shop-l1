package org.skypro.skyshop.Searchable;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchables;


    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public Set<Searchable> search(String text) {
        return searchables.stream()
                .filter(i -> i.getSearchTerm().contains(text))
                .collect(Collectors.toCollection(()-> new TreeSet<>(new ReverseLengthComparator())));
    }


    public void addSearchable(Searchable searchable) {
        searchables.add(searchable);
    }

    public int getNumberMatches(String searchWord, String str) {

        int numb = 0;
        int index = 0;
        int foundIndex = str.indexOf(searchWord, index);

        while (foundIndex != -1) {
            numb++;
            index = foundIndex + str.length();
            foundIndex = str.indexOf(searchWord, index);
        }
        return numb;
    }

    public String getBestResult(String search) throws BestResultNotFound {
        Searchable bestResult = null;
        int maxMach = 0;
        int numb;
        for (Searchable item : searchables) {
            String str = item.getSearchTerm().toLowerCase();
            String searchWord = search.toLowerCase();
            numb = getNumberMatches(searchWord, str);
            if (numb > maxMach) {
                maxMach = numb;
                bestResult = item;
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound();
        }
        return bestResult.getStringRepresentation();
    }
}



