package org.skypro.skyshop.Searchable;

import org.skypro.skyshop.exception.BestResultNotFound;

public class SearchEngine {
    int size;
    private Searchable[] searchables;
    private int currentIndex = 0;

    public SearchEngine(int size) {
        this.size = size;
        searchables = new Searchable[size];
    }

    public Searchable[] search(String text) {
        Searchable[] resultSearch = new Searchable[5];
        int counter = 0;
        for (Searchable searchable : searchables) {
            if (counter == 5) {
                break;
            }
            if (searchable.getSearchTerm().contains(text)) {
                resultSearch[counter] = searchable;
                counter++;
            }
        }
        return resultSearch;
    }

    public void addSearchable(Searchable searchable) {
        if (currentIndex >= size) {
            System.out.println("Невозможно добавить объект");
        } else {
            searchables[currentIndex] = searchable;
            currentIndex++;
        }
    }

    public void pintSearchables() {
        for (Searchable searchable : searchables) {
            System.out.println(searchable.getStringRepresentation());
        }
    }

    public void printResult(Searchable[] resultSearcheble) {
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



