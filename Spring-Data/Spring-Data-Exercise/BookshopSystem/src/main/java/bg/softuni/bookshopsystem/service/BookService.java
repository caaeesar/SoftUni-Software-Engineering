package bg.softuni.bookshopsystem.service;

import bg.softuni.bookshopsystem.entity.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {

    boolean isDataSeeded();
    void seedBooks() throws IOException;

   List<Book> getAllBooksAfter2000();
   List<Book> getAllBooksBefore1990();

   List<Book> getAllBooksByGeorgePowell();



}
