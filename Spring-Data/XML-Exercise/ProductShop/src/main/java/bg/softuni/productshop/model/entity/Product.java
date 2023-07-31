package bg.softuni.productshop.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @ManyToOne
    private User buyer;
    @ManyToOne
    private User seller;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "products_categories",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
    )
    private Set<Category> categories;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
    }
}
