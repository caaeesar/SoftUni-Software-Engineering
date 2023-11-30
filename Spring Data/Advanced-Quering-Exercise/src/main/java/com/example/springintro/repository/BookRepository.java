package com.example.springintro.repository;

import com.example.springintro.model.dto.ReducedBookInformation;
import com.example.springintro.model.enums.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.enums.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> getBooksByAgeRestrictionIs(AgeRestriction ageRestriction);
    List<Book> getBooksByCopiesLessThanAndEditionTypeIs(int copies, EditionType editionType);

    List<Book> getBooksByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal upper);

    List<Book> getBooksByReleaseDateBeforeOrReleaseDateAfter(LocalDate lowe, LocalDate upper);

    List<Book> getBooksByReleaseDateBefore(LocalDate releasedDate);

    List<Book> getBooksByTitleContainsIgnoreCase(String str);

    List<Book> getBooksByAuthor_LastNameStartsWith(String startStr);

    @Query(""" 
            SELECT count(b)
            FROM Book AS b
            WHERE length(b.title) > :titleLength
            """)
    int countBooksByTitleWithLengthMoreThan(int titleLength);

    // automatically mapped
    List<ReducedBookInformation> getBooksByTitle(String title);

    List<Book> getBooksByReleaseDateAfter(LocalDate releaseDate);

    @Transactional
    int removeBooksByCopiesLessThan(int copies);

    @Procedure(procedureName = "usp_get_all_books_by_author")
    int getAllBooksByAuthorNames(String fullName);

}
