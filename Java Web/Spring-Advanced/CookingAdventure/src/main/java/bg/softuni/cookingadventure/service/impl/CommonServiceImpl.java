package bg.softuni.cookingadventure.service.impl;

import bg.softuni.cookingadventure.model.entity.RecipeEntity;
import bg.softuni.cookingadventure.model.entity.UserEntity;
import bg.softuni.cookingadventure.repository.CommentRepository;
import bg.softuni.cookingadventure.repository.RecipeRepository;
import bg.softuni.cookingadventure.repository.UserRepository;
import bg.softuni.cookingadventure.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {

    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CommonServiceImpl(UserRepository userRepository, RecipeRepository recipeRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void deleteRecipeById(Long id, String username) {
        UserEntity user = userRepository.findUserByUsername(username).get();
        RecipeEntity recipe = recipeRepository.findById(id).get();

        recipe.setIngredients(null);
        commentRepository.deleteAll(recipe.getComments());
        recipe.setComments(null);
        user.getCreatedRecipes().remove(recipe);
        user.getFavoriteRecipes().remove(recipe);
        removeFromAllFavorites(id);

        userRepository.saveAndFlush(user);
        recipeRepository.deleteById(id);
    }

    @Override
    public void removeFromAllFavorites(Long recipeId) {
        List<UserEntity> users = userRepository.findAll();
        RecipeEntity recipe = recipeRepository.findById(recipeId).get();

        for (UserEntity user : users) {
            user.getFavoriteRecipes().remove(recipe);
            userRepository.save(user);
        }
    }
}

