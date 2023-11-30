package bg.softuni.bookshopsystem.service.impl;

import bg.softuni.bookshopsystem.entity.Author;
import bg.softuni.bookshopsystem.repository.AuthorRepository;
import bg.softuni.bookshopsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static bg.softuni.bookshopsystem.constants.FilePath.*;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepo;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public boolean isDataSeeded() {
        return this.authorRepo.count() > 0;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (isDataSeeded()) {
            return;
        }
        List<String> allLines = Files.readAllLines(Path.of(ROOT_PATH + AUTHORS_FILE_NAME));
        allLines.forEach(line -> {
                    Author author = new Author(line.split("\\s+")[0], line.split("\\s+")[1]);
                    this.authorRepo.save(author);
                }
        );
    }

    @Override
    public List<Author> getAllAuthorsOrderedByBooksCountDesc() {
      return this.authorRepo.findAllByBooksOrderByDesc();
    }

}
