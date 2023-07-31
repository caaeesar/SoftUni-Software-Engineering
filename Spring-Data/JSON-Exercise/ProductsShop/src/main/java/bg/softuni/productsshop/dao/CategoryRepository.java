package bg.softuni.productsshop.dao;

import bg.softuni.productsshop.model.dto.categoryDtos.CategorySummaryDto;
import bg.softuni.productsshop.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("""
        SELECT new bg.softuni.productsshop.model.dto.categoryDtos.CategorySummaryDto
        (c.name, COUNT(p), AVG(p.price), SUM(p.price))
        FROM Category AS c
        JOIN c.products AS p
        GROUP BY c.name
        ORDER BY COUNT(p) DESC
""")
    List<CategorySummaryDto> getCategoriesSummary();

}
