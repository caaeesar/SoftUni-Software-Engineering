package com.example.springintro.service.impl;

import com.example.springintro.model.dto.ReducedBookInformation;
import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.Category;
import com.example.springintro.model.enums.AgeRestriction;
import com.example.springintro.model.enums.EditionType;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> getBooksTitlesByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository.getBooksByAgeRestrictionIs(ageRestriction);
    }

    @Override
    public List<Book> getGoldenBooksLessThan5000Copies() {
        return this.bookRepository.getBooksByCopiesLessThanAndEditionTypeIs(5000, EditionType.GOLD);
    }

    @Override
    public List<Book> getBooksByPrice() {
        return this.bookRepository.getBooksByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40));
    }

    @Override
    public List<Book> getNotReleasedBooks(int year) {
        LocalDate lower = LocalDate.of(year, 1,1);
        LocalDate upper = LocalDate.of(year, 12, 31);
        return this.bookRepository.getBooksByReleaseDateBeforeOrReleaseDateAfter(lower,upper);
    }

    @Override
    public List<Book> getBooksReleasedBeforeDate(LocalDate releasedDate) {
        return this.bookRepository.getBooksByReleaseDateBefore(releasedDate);
    }

    @Override
    public List<Book> getBooksWithTitleContainsStr(String srt) {
        return this.bookRepository.getBooksByTitleContainsIgnoreCase(srt);
    }

    @Override
    public List<Book> getBooksByAuthorsLastNameStartsWith(String startStr) {
        return this.bookRepository.getBooksByAuthor_LastNameStartsWith(startStr);
    }

    @Override
    public int getCountOfBooksWithTitleLengthMoreThan(int titleLength) {
        return this.bookRepository.countBooksByTitleWithLengthMoreThan(titleLength);
    }

    @Override
    public List<ReducedBookInformation> getReducedBooksByTitle(String title) {
        return this.bookRepository.getBooksByTitle(title);
    }

    @Override
    public int increaseBookCopiesByReleasedDate(LocalDate releaseDate, int addedCopies) {
       List<Book> books = this.bookRepository.getBooksByReleaseDateAfter(releaseDate);
       books.forEach(book -> book.setCopies(book.getCopies() + addedCopies));
       this.bookRepository.saveAll(books);
       return books.size() * addedCopies;
    }

    @Override
    public int removeBooksByCopies(int copies) {
       return this.bookRepository.removeBooksByCopiesLessThan(copies);
    }

    @Override
    public int getTotalBooksByAuthorNames(String fullName) {
        return this.bookRepository.getAllBooksByAuthorNames(fullName);
    }


    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
