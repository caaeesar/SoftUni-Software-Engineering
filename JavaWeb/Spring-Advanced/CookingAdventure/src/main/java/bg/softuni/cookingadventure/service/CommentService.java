package bg.softuni.cookingadventure.service;

import bg.softuni.cookingadventure.model.service.CommentCreateServiceModel;
import bg.softuni.cookingadventure.model.view.CommentViewModel;

import java.util.List;

public interface CommentService {

    List<CommentViewModel> getCommentsByRecipe(Long id);

    CommentViewModel createComment(CommentCreateServiceModel commentCreateServiceModel, Long recipeId, String username);

}
