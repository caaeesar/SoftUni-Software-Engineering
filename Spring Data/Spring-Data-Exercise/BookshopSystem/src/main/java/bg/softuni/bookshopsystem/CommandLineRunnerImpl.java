package bg.softuni.bookshopsystem;

import bg.softuni.bookshopsystem.entity.Author;
import bg.softuni.bookshopsystem.entity.Book;
import bg.softuni.bookshopsystem.service.AuthorService;
import bg.softuni.bookshopsystem.service.BookService;
import bg.softuni.bookshopsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private AuthorService authorService;
    private CategoryService categoryService;
    private BookService bookService;

    @Autowired
    public CommandLineRunnerImpl(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedAllData();

        System.out.println("Enter exercise number (queries):");
        int exNumber = new Scanner(System.in).nextInt();

        switch (exNumber) {
            case 1:
                this.bookService.getAllBooksAfter2000().forEach(book -> System.out.println(book.getTitle()));
                break;
            case 2:
                this.bookService.getAllBooksAfter2000().forEach(book -> System.out.println(book.getAuthor().getFullNameFormat()));
                break;
            case 3:
                this.authorService.getAllAuthorsOrderedByBooksCountDesc().forEach(Author::getFullNameAndBooksSizeFormat);
                break;
            case 4:
                this.bookService.getAllBooksByGeorgePowell().forEach(Book::getBookTitleReleaseDataAndCopiesFormat);
                break;
        }
    }

    private void seedAllData() throws IOException {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();
    }
}
