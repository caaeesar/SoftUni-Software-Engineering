package bg.softuni.cookingadventure.service;

import bg.softuni.cookingadventure.model.entity.UserEntity;
import bg.softuni.cookingadventure.model.service.UserServiceModel;
import bg.softuni.cookingadventure.model.view.FavoriteRecipesViewModel;
import bg.softuni.cookingadventure.model.view.MyRecipesViewModel;
import bg.softuni.cookingadventure.model.view.UserViewModel;

import java.util.List;
import java.util.Set;

public interface UserService {
    boolean registerUser(UserServiceModel userServiceModel);
    List<MyRecipesViewModel> findCreatedRecipes(String username);
    Set<FavoriteRecipesViewModel> findFavoriteRecipes(String username);
    void addToFavorite(Long id, String username);
    void removeFromFavorite(Long id, String username);
    UserEntity getUserByUsername(String username);
    List<UserViewModel> getAllUsers();
    void deleteUser(Long id);
    void manageUserRoles(Long id, List<Long> roleIds);
}
