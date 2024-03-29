package bg.softuni.productshop.dao;

import bg.softuni.productshop.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> getProductsByPriceBetweenOrderByPriceAsc(BigDecimal lower, BigDecimal upper);

}
