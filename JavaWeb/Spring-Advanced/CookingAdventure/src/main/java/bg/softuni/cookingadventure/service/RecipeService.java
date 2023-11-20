package bg.softuni.cookingadventure.service;

import bg.softuni.cookingadventure.model.service.RecipeAddServiceModel;
import bg.softuni.cookingadventure.model.view.AllRecipesViewModel;
import bg.softuni.cookingadventure.model.view.RecipeDetailsViewModel;

import java.util.List;

public interface RecipeService {
    void createRecipe(RecipeAddServiceModel recipeAddServiceModel, String username);
    List<AllRecipesViewModel> getAllRecipes();
    RecipeDetailsViewModel findRecipeById(Long id);
    void deleteRecipeById(Long id, String username);
    List<RecipeDetailsViewModel> getAllRecipesDetails();
}
