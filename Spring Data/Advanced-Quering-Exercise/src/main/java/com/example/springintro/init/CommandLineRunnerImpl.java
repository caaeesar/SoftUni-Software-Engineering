package com.example.springintro.init;

import com.example.springintro.model.enums.AgeRestriction;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static com.example.springintro.message.PromptsMessage.*;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private Scanner scanner;
    private int copies;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, Scanner scanner) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Enter exercise number:");
        int exNumber = Integer.parseInt(scanner.nextLine());

        switch (exNumber) {
            case 1:
                System.out.println(ENTER_AGE_RESTRICTION);
                AgeRestriction ageRestriction = AgeRestriction.valueOf(scanner.nextLine().toUpperCase());
                this.bookService.getBooksTitlesByAgeRestriction(ageRestriction)
                        .forEach(book -> System.out.println(book.getTitle()));
                break;
            case 2:
                this.bookService.getGoldenBooksLessThan5000Copies()
                        .forEach(book -> System.out.println(book.getTitle()));
                break;
            case 3:
                this.bookService.getBooksByPrice() // not between 5 - 40
                        .forEach(book -> System.out.println(book.findTitleAndPriceFormat()));
                break;
            case 4:
                System.out.println(ENTER_YEAR);
                int year = scanner.nextInt();
                this.bookService.getNotReleasedBooks(year)
                        .forEach(book -> System.out.println(book.getTitle()));
                break;
            case 5:
                System.out.println(ENTER_RELEASED_DATE);
                LocalDate releasedDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                this.bookService.getBooksReleasedBeforeDate(releasedDate)
                        .forEach(book -> System.out.println(book.findTitleTypeAndPriceFormat()));
                break;
            case 6:
                System.out.println(ENTER_STR);
                String endsStr = scanner.nextLine();
                this.authorService.getAuthorsFirstNameEndsWithStr(endsStr)
                        .forEach(author -> System.out.println(author.findFirstNameAndLastNameFormat()));
                break;
            case 7:
                System.out.println(ENTER_STR);
                String str = scanner.nextLine();
                this.bookService.getBooksWithTitleContainsStr(str)
                        .forEach(book -> System.out.println(book.getTitle()));
                break;
            case 8:
                System.out.println(ENTER_STR);
                String startStr = scanner.nextLine();
                this.bookService.getBooksByAuthorsLastNameStartsWith(startStr)
                        .forEach(book -> System.out.println(book.findTitleAndAuthorsNameFormat()));
                break;
            case 9:
                System.out.println(ENTER_TITLE_LENGTH);
                int titleLength = scanner.nextInt();
                System.out.println(this.bookService.getCountOfBooksWithTitleLengthMoreThan(titleLength));
                break;
            case 10:
                this.authorService.getTotalBookCopiesByAuthors().forEach(System.out::println);
                break;
            case 11:
                System.out.println(ENTER_TITLE);
                String title = scanner.nextLine();
                this.bookService.getReducedBooksByTitle(title).forEach(System.out::println);
                break;
            case 12:
                System.out.println(ENTER_DATE);
                String dateInfo = scanner.nextLine();
                LocalDate releaseDate = LocalDate.parse(dateInfo, DateTimeFormatter.ofPattern("dd MMM yyyy"));
                System.out.println(ENTER_BOOK_COPIES);
                copies = Integer.parseInt(scanner.nextLine());
                System.out.println(this.bookService.increaseBookCopiesByReleasedDate(releaseDate, copies));
                break;
            case 13:
                System.out.println(ENTER_BOOK_COPIES);
                copies = Integer.parseInt(scanner.nextLine());
                int removed = this.bookService.removeBooksByCopies(copies);
                System.out.printf("%d was deleted.", removed);
                break;
            case 14:
                System.out.println(ENTER_AUTHOR_NAMES);
                String fullName = scanner.nextLine();
                System.out.printf("%s has written %d books", fullName, this.bookService.getTotalBooksByAuthorNames(fullName));
                break;
        }
    }
    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
