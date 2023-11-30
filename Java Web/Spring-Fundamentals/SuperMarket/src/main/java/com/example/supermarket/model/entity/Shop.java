package com.example.supermarket.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "shops")
public class Shop extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Size(min = 2)
    private String address;

    @Column
    @Size(min = 2)
    private String name;

    @ManyToOne
    private Town town;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "products_shops",
            joinColumns = @JoinColumn(name = "shop_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private Set<Product> products;

    @OneToMany(mappedBy = "shop", targetEntity = Seller.class, fetch = FetchType.EAGER)
    private Set<Seller> sellers;

    public Shop(String address, String name, Town town) {
        this.address = address;
        this.name = name;
        this.town = town;
    }
}
