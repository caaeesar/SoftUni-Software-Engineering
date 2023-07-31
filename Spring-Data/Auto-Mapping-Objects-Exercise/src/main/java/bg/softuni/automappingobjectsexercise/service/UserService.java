package bg.softuni.automappingobjectsexercise.service;

import bg.softuni.automappingobjectsexercise.model.dto.user.UserLoginDto;
import bg.softuni.automappingobjectsexercise.model.dto.user.UserRegisterDto;
import bg.softuni.automappingobjectsexercise.model.entity.User;

public interface UserService {
    String registerUser(UserRegisterDto userDto);

    String loginUser(UserLoginDto userDto);

    String logout();

    boolean isLoggedInUserAdmin();

    User getLoggedInUser();

    String addGameInShoppingCard(String title);

    String removeGameFromShoppingCard(String title);

    String buyGame();

    String getOwedGames();
}
