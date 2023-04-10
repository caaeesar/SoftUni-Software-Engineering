package IteratorsAndComparators.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) { // can be no authors, one author, or many authors
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    private void setAuthors(String... authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<>();
        } else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.title,this.year);
    }

    @Override
    public int compareTo(Book otherBook) {
        int result = this.getTitle().compareTo(otherBook.getTitle());
        if (result == 0) {
           result = Integer.compare(this.getYear(),otherBook.getYear());
        }
        return result;
    }
}
