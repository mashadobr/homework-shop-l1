package org.skypro.skyshop.Searchable;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables;


    public SearchEngine() {
        this.searchables = new LinkedList<>();
    }

    public List<Searchable> search(String text) {
        List <Searchable> resultSearch =  new LinkedList<>() ;
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(text)) {
                resultSearch.add(searchable);
            }
        }
        return resultSearch;
    }

    public void addSearchable(Searchable searchable) {
            searchables.add(searchable);
        }


    public void pintSearchables() {
        System.out.println("Список объектов:");
        for (Searchable searchable: searchables) {
            System.out.println(searchable.getStringRepresentation());
        }
    }

    public void printResult(List<Searchable> resultSearcheble) {
        System.out.println("Результаты поиска");
        for (Searchable result : resultSearcheble) {
            if (result == null) {
                break;
            } else {
                System.out.println(result.getStringRepresentation());
            }
        }
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



