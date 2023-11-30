package bg.softuni.cookingadventure.service;

public interface CommonService {

    void deleteRecipeById(Long id, String username);

    void removeFromAllFavorites(Long recipeId);
}
