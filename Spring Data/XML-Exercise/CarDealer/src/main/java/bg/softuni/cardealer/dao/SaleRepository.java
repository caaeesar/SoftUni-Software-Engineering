package bg.softuni.cardealer.dao;

import bg.softuni.cardealer.model.dto.exports.SaleWithDiscountInfoDto;
import bg.softuni.cardealer.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("""
                  SELECT DISTINCT new bg.softuni.cardealer.model.dto.exports.SaleWithDiscountInfoDto(
                      ca.make,
                      ca.model,
                      ca.travelledDistance,
                      c.name,
                      s.discount,
                     CAST(SUM(p.price) AS Double),
                     CAST(p.price - (p.price * s.discount / 100.00) AS Double)
                )
                FROM Customer c
                JOIN c.sales s
                JOIN s.car ca
                JOIN ca.parts AS p
                GROUP BY ca.id
            """)
    List<SaleWithDiscountInfoDto> getSalesWithCarsAndDiscountInfo();
}
