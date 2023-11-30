package bg.softuni.bookshopsystem.service;

import bg.softuni.bookshopsystem.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    boolean isDataSeeded();
    void seedAuthors() throws IOException;


   List<Author> getAllAuthorsOrderedByBooksCountDesc();

}
