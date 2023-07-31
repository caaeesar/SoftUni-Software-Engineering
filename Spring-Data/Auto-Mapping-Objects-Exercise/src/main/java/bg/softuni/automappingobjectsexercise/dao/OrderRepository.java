package bg.softuni.automappingobjectsexercise.dao;

import bg.softuni.automappingobjectsexercise.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
