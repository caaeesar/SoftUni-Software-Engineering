package bg.softuni.bookshopsystem.repository;

import bg.softuni.bookshopsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByReleaseDateAfter(LocalDate releaseDate);

    List<Book> findBooksByReleaseDateBefore(LocalDate releaseDate);

    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

}