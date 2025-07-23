package org.skypro.skyshop.Searchable;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private List<Searchable> searchables;


    public SearchEngine() {
        this.searchables = new LinkedList<>();
    }

    public Map<String, Searchable> search(String text) {
        Map<String, Searchable> resultSearch = new TreeMap<>();

        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(text)) {
                resultSearch.put(searchable.getSearchTerm(), searchable);
            }
        }
        return resultSearch;
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



