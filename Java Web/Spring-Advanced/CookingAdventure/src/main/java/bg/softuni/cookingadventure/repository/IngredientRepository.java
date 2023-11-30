package bg.softuni.cookingadventure.repository;

import bg.softuni.cookingadventure.model.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {
    Optional<IngredientEntity> findByName(String name);

}
