package bg.softuni.coffeeshopapplication.repository;

import bg.softuni.coffeeshopapplication.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrdersByOrderByPrice();

}
