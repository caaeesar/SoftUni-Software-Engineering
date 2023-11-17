package bg.softuni.shoppinglistapplication.repository;

import bg.softuni.shoppinglistapplication.model.entity.Category;
import bg.softuni.shoppinglistapplication.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Category getCategoryByName(CategoryName name);

}
