package bg.softuni.cookingadventure.model.view;

import bg.softuni.cookingadventure.model.entity.IngredientEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class RecipeDetailsViewModel {

    private Long id;

    private String imageUrl;

    private String title;

    private String description;

    private List<IngredientEntity> ingredients;

    private String categoryName;

    private LocalTime preparationTime;

    private UserProfileViewModel author;
}
