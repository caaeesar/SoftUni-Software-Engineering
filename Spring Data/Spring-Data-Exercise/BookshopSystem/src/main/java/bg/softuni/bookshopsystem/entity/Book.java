package bg.softuni.bookshopsystem.entity;

import bg.softuni.bookshopsystem.enums.AgeRestriction;
import bg.softuni.bookshopsystem.enums.EditionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Book extends BaseEntity {
    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    EditionType editionType;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int copies;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AgeRestriction ageRestriction;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @ManyToMany
    @JoinTable(
            name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
    )
    private Set<Category> categories;


    public String getBookTitleReleaseDataAndCopiesFormat() {
        return this.title + " " + this.releaseDate + " " + this.copies;
    }

}
