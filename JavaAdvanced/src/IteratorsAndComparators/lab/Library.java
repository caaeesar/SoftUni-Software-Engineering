package IteratorsAndComparators.lab;

import IteratorsAndComparators.lab.Book;

import java.util.Iterator;

// class which contains thing it's can be iterable
public class Library implements Iterable<Book>{
    private Book[] books;

    // vargs
    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator(); // return iterator
    }

    private class LibIterator implements Iterator<Book> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < books.length;
        }

        @Override
        public Book next() {
            return books[index++];
        }
    }

}
