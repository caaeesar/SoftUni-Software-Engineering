package bg.softuni.shoppinglistapplication.repository;

import bg.softuni.shoppinglistapplication.model.entity.Product;
import bg.softuni.shoppinglistapplication.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Optional<Product> findByName(String name);

    List<Product> findProductByCategory_Name(CategoryName name);

    @Query("SELECT SUM(p.price) FROM Product AS p")
    BigDecimal getTotalPrice();

}
