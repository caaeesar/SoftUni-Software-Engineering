package IteratorsAndComparators.lab;

import IteratorsAndComparators.lab.Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        // class String implements Comparable -> we can use compareTo() methods
        int result = b1.getTitle().compareTo(b2.getTitle());
        if (result == 0) {
            result = Integer.compare(b1.getYear(),b2.getYear());
        }
        return result;
    }
}
