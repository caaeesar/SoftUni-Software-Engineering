package bg.softuni.bookshopsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Setter
@Getter
@NoArgsConstructor
public class Category extends BaseEntity {

    @Column(nullable = false)
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
