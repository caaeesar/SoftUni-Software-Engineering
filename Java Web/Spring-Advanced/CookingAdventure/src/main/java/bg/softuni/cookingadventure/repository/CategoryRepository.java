package bg.softuni.cookingadventure.repository;

import bg.softuni.cookingadventure.model.entity.CategoryEntity;
import bg.softuni.cookingadventure.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity getByNameIs(CategoryName name);
}
