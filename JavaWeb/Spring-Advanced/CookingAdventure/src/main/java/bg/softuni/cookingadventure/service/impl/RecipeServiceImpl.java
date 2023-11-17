package bg.softuni.cookingadventure.service.impl;

import bg.softuni.cookingadventure.exception.ObjectNotFoundException;
import bg.softuni.cookingadventure.model.entity.CategoryEntity;
import bg.softuni.cookingadventure.model.entity.IngredientEntity;
import bg.softuni.cookingadventure.model.entity.RecipeEntity;
import bg.softuni.cookingadventure.model.entity.UserEntity;
import bg.softuni.cookingadventure.model.service.RecipeAddServiceModel;
import bg.softuni.cookingadventure.model.view.AllRecipesViewModel;
import bg.softuni.cookingadventure.model.view.RecipeDetailsViewModel;
import bg.softuni.cookingadventure.repository.CategoryRepository;
import bg.softuni.cookingadventure.repository.IngredientRepository;
import bg.softuni.cookingadventure.repository.RecipeRepository;
import bg.softuni.cookingadventure.repository.UserRepository;
import bg.softuni.cookingadventure.service.RecipeService;
import bg.softuni.cookingadventure.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final IngredientRepository ingredientRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RecipeServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, RecipeRepository recipeRepository, IngredientRepository ingredientRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createRecipe(RecipeAddServiceModel recipeAddServiceModel, String username) {
        String[] ingredientNames = recipeAddServiceModel.getIngredientNames().split(",\\s*");
        List<IngredientEntity> ingredients = new ArrayList<>();

        for (int i = 0; i < ingredientNames.length; i++) {
            String ingredientName = ingredientNames[i];
            IngredientEntity ingredient;
            Optional<IngredientEntity> optionalIngredient = ingredientRepository.findByName(ingredientName);

            if (optionalIngredient.isEmpty()) {
                ingredient = new IngredientEntity(ingredientName);
                ingredientRepository.saveAndFlush(ingredient);
            } else {
                ingredient = optionalIngredient.get();
            }

            ingredients.add(ingredient);
        }

        UserEntity user = userRepository.findUserByUsername(username).get();
        CategoryEntity category = categoryRepository.getByNameIs(recipeAddServiceModel.getCategory());
        RecipeEntity recipe = modelMapper.map(recipeAddServiceModel,RecipeEntity.class);

        recipe.getIngredients().addAll(ingredients);
        recipe.setCategory(category);
        user.getCreatedRecipes().add(recipe);
        recipe.setAuthor(user);

        recipeRepository.save(recipe);
    }

    @Override
    public List<AllRecipesViewModel> getAllRecipes() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeEntity -> modelMapper.map(recipeEntity, AllRecipesViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDetailsViewModel findRecipeById(Long id) {
        RecipeEntity recipeEntity = recipeRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Recipe not found with id: " + id));
        return modelMapper.map(recipeEntity, RecipeDetailsViewModel.class);
    }

    @Override
    public void deleteRecipeById(Long id, String username) {
        UserEntity user = userRepository.findUserByUsername(username).get();
        RecipeEntity recipe = recipeRepository.findById(id).get();

        recipe.setIngredients(null);
       /* recipe.setComments(null);*/
        user.getCreatedRecipes().remove(recipe);
        user.getFavoriteRecipes().remove(recipe);
        removeFromAllFavorites(id);

        userRepository.saveAndFlush(user);
        recipeRepository.deleteById(id);
    }

    @Override
    public void deleteRecipeById(Long id) {
        RecipeEntity recipe = recipeRepository.findById(id).get();
        UserEntity user = recipe.getAuthor();
        user.getCreatedRecipes().remove(recipe);
        removeFromAllFavorites(id);
        recipe.setAuthor(null);

        userRepository.saveAndFlush(user);
        recipeRepository.deleteById(id);
    }

    @Override
    public List<RecipeDetailsViewModel> getAllRecipesDetails() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeEntity -> modelMapper.map(recipeEntity, RecipeDetailsViewModel.class))
                .collect(Collectors.toList());
    }

    private void removeFromAllFavorites(Long id) {
        List<UserEntity> users = userRepository.findAll();
        RecipeEntity recipe = recipeRepository.findById(id).get();

        for (UserEntity user : users) {
            user.getFavoriteRecipes().remove(recipe);
            userRepository.save(user);
        }
    }
}
