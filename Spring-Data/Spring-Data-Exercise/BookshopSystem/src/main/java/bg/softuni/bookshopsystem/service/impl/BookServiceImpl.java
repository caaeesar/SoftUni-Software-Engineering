package bg.softuni.bookshopsystem.service.impl;

import bg.softuni.bookshopsystem.entity.Author;
import bg.softuni.bookshopsystem.entity.Book;
import bg.softuni.bookshopsystem.entity.Category;
import bg.softuni.bookshopsystem.enums.AgeRestriction;
import bg.softuni.bookshopsystem.enums.EditionType;
import bg.softuni.bookshopsystem.repository.AuthorRepository;
import bg.softuni.bookshopsystem.repository.BookRepository;
import bg.softuni.bookshopsystem.repository.CategoryRepository;
import bg.softuni.bookshopsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static bg.softuni.bookshopsystem.constants.FilePath.BOOKS_FILE_NAME;
import static bg.softuni.bookshopsystem.constants.FilePath.ROOT_PATH;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepo;
    private AuthorRepository authorRepo;
    private CategoryRepository categoryRepo;


    @Autowired
    public BookServiceImpl(BookRepository bookRepo, AuthorRepository authorRepo, CategoryRepository categoryRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public boolean isDataSeeded() {
        return this.bookRepo.count() > 0;
    }

    @Override
    public void seedBooks() throws IOException {
        if (isDataSeeded()) {
            return;
        }

        List<String> allLines = Files.readAllLines(Path.of(ROOT_PATH + BOOKS_FILE_NAME));
        allLines.forEach(line -> {
            Book book = createBook(line);
            this.bookRepo.save(book);
        });
    }

    @Override
    public List<Book> getAllBooksAfter2000() {
        return this.bookRepo.findBooksByReleaseDateAfter(LocalDate.of(2000,12, 31));
    }

    @Override
    public List<Book> getAllBooksBefore1990() {
        return this.bookRepo.findBooksByReleaseDateBefore(LocalDate.of(1990, 1,1));
    }


    public List<Book> getAllBooksByGeorgePowell() {
       return this.bookRepo.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc("George", "Powell");
    }

    private Book createBook(String line) {
        String[] data = line.split("\\s+");
        Author author = getRandomAuthor();
        int editionTypeIndex = Integer.parseInt(data[0]);
        EditionType editionType = EditionType.values()[editionTypeIndex];
        LocalDate releaseDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        int copies = Integer.parseInt(data[2]);
        BigDecimal price = new BigDecimal(data[3]);
        int ageRestrictionIndex = Integer.parseInt(data[4]);
        AgeRestriction ageRestriction = AgeRestriction.values()[ageRestrictionIndex];
        String title = Arrays.stream(data).skip(5).collect(Collectors.joining(" "));
        Set<Category> categories = getRandomCategories();

        return Book.builder().author(author)
                .editionType(editionType)
                .releaseDate(releaseDate)
                .copies(copies)
                .price(price)
                .ageRestriction(ageRestriction)
                .title(title)
                .categories(categories)
                .build();
    }

    private Set<Category> getRandomCategories() {
        Set<Category> result = new HashSet<>();
        Random random = new Random();
        int bound = random.nextInt( 1, (int) (this.categoryRepo.count() + 1));
        for (long i = 0; i < bound; i++) {
            result.add(this.categoryRepo.findById(i).orElse(null));
        }
        return result;
    }

    private Author getRandomAuthor() {
        Random random = new Random();
        long randomIndex = random.nextInt(1, (int) this.authorRepo.count() + 1);
        return this.authorRepo.findById(randomIndex).orElse(null);
    }
}
