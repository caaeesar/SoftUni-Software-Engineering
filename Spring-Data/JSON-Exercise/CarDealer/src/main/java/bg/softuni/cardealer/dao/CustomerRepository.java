package bg.softuni.cardealer.dao;

import bg.softuni.cardealer.model.dto.exportDtos.CustomerWithSalesDto;
import bg.softuni.cardealer.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> getCustomersByOrderByBirthDateAscIsYoungDriverAsc();

    @Query("""
    SELECT new bg.softuni.cardealer.model.dto.exportDtos.CustomerWithSalesDto(c.name, COUNT(DISTINCT s.car.id), SUM(p.price))
    FROM Customer AS c
    JOIN Sale AS s ON s.customer = c
    JOIN Car AS ca ON s.car = ca
    JOIN ca.parts AS p
    GROUP BY c.name
""")
    List<CustomerWithSalesDto> getCustomersWithSalesInfo();

}
