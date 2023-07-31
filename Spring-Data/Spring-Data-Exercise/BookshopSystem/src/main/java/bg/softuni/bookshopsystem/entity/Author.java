package bg.softuni.bookshopsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "authors")
@Setter
@Getter
@NoArgsConstructor
public class Author extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "author", targetEntity = Book.class, fetch = FetchType.EAGER)
    private Set<Book> books;

    public Author(String lastName) {
        this.lastName = lastName;
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullNameAndBooksSizeFormat() {
        return this.firstName + " " + this.lastName + " " + this.books.size();
    }

    public String getFullNameFormat() {
        return this.firstName + " " + this.lastName;
    }
}
