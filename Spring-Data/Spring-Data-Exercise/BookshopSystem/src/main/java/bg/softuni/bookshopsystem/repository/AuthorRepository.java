package bg.softuni.bookshopsystem.repository;

import bg.softuni.bookshopsystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author AS a ORDER BY size(a.books) DESC") // JPQL - object-oriented query language
    List<Author> findAllByBooksOrderByDesc();
}
