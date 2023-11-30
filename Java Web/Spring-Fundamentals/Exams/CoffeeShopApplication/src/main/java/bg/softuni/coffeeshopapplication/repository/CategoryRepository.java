package bg.softuni.coffeeshopapplication.repository;

import bg.softuni.coffeeshopapplication.model.entity.Category;
import bg.softuni.coffeeshopapplication.model.entity.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category getByName(CategoryType name);
}
