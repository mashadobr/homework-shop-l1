package org.skypro.skyshop.Searchable;

import java.util.Comparator;

public record ReverseLengthComparator() implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        int lenghtCompare = Integer.compare(o2.getSearchTerm().length(), o1.getSearchTerm().length());
        if (lenghtCompare != 0) {
            return Integer.compare(o2.getSearchTerm().length(), o1.getSearchTerm().length());
        }
        return o1.getSearchTerm().compareTo(o2.getSearchTerm());
    }
}

