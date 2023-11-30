package bg.softuni.productshop.dao;

import bg.softuni.productshop.model.dto.exports.category.CategorySummaryDto;
import bg.softuni.productshop.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("""
        SELECT new bg.softuni.productshop.model.dto.exports.category.CategorySummaryDto
        (c.name, COUNT(p), AVG(p.price), SUM(p.price))
        FROM Category AS c
        JOIN c.products AS p
        GROUP BY c.name
        ORDER BY COUNT(p) DESC
""")
    List<CategorySummaryDto> getCategoriesSummary();
}
