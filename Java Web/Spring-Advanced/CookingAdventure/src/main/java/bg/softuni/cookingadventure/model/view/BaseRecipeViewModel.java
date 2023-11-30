package bg.softuni.cookingadventure.model.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseRecipeViewModel {

    private Long id;

    private String imageUrl;

    private String title;
}