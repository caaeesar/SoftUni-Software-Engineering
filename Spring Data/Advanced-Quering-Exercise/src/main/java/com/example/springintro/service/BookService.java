package com.example.springintro.service;

import com.example.springintro.model.dto.ReducedBookInformation;
import com.example.springintro.model.enums.AgeRestriction;
import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> getBooksTitlesByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> getGoldenBooksLessThan5000Copies();

    List<Book> getBooksByPrice();

    List<Book> getNotReleasedBooks(int year);

    List<Book> getBooksReleasedBeforeDate(LocalDate releasedDate);

    List<Book> getBooksWithTitleContainsStr(String srt);

    List<Book> getBooksByAuthorsLastNameStartsWith(String startStr);

    int getCountOfBooksWithTitleLengthMoreThan(int titleLength);

    List<ReducedBookInformation> getReducedBooksByTitle(String title);

    int increaseBookCopiesByReleasedDate(LocalDate releaseDate, int addedCopies);

    int removeBooksByCopies(int copies);

    int getTotalBooksByAuthorNames(String fullName);
}
