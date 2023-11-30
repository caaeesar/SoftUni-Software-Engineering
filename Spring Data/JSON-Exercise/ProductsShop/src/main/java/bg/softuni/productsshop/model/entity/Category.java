package bg.softuni.productsshop.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(nullable = false, length = 15, unique = true)
    private String name;

    @ManyToMany(mappedBy = "categories", targetEntity = Product.class, fetch = FetchType.EAGER)
    private Set<Product> products;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

}
