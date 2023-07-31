package bg.softuni.automappingobjectsexercise.service.impl;

import bg.softuni.automappingobjectsexercise.dao.GameRepository;
import bg.softuni.automappingobjectsexercise.dao.OrderRepository;
import bg.softuni.automappingobjectsexercise.dao.UserRepository;
import bg.softuni.automappingobjectsexercise.exception.IncorrectPasswordException;
import bg.softuni.automappingobjectsexercise.model.dto.user.UserLoginDto;
import bg.softuni.automappingobjectsexercise.model.dto.user.UserRegisterDto;
import bg.softuni.automappingobjectsexercise.model.entity.Game;
import bg.softuni.automappingobjectsexercise.model.entity.Order;
import bg.softuni.automappingobjectsexercise.model.entity.User;
import bg.softuni.automappingobjectsexercise.service.UserService;
import bg.softuni.automappingobjectsexercise.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static bg.softuni.automappingobjectsexercise.constant.ErrorMessages.*;
import static bg.softuni.automappingobjectsexercise.constant.InformMessages.*;

@Service
public class UserServiceImpl implements UserService {

    private User loggedInUser;
    private UserRepository userRepo;
    private ValidationUtil validationUtil;
    private ModelMapper mapper;
    private GameRepository gameRepo;
    private OrderRepository orderRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, ValidationUtil validationUtil, ModelMapper mapper, GameRepository gameRepo, OrderRepository orderRepo) {
        this.userRepo = userRepo;
        this.validationUtil = validationUtil;
        this.mapper = mapper;
        this.gameRepo = gameRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public String registerUser(UserRegisterDto userDto) {
        // checked passwords
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            throw new IncorrectPasswordException(INCORRECT_PASSWORD);
        }

        // checked for valid data
        if (!this.validationUtil.isValid(userDto)) {
            Set<ConstraintViolation<UserRegisterDto>> violations = this.validationUtil.violations(userDto);
            return violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(System.lineSeparator()));
        } else {
            // mapping dto to entity
            User user = this.mapper.map(userDto, User.class);

            // first register user is admin
            user.setAdmin(this.userRepo.count() == 0);

            // save in database
            this.userRepo.save(user);
            return String.format(SUCCESSFULLY_REGISTERED, user.getFullName());
        }
    }

    @Override
    public String loginUser(UserLoginDto userDto) {
        if (!this.validationUtil.isValid(userDto)) {
            Set<ConstraintViolation<UserLoginDto>> violations = this.validationUtil.violations(userDto);
            return violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(System.lineSeparator()));
        }

        if (this.loggedInUser != null) {
            return USER_IS_LOGGED;
        }

        Optional<User> user = this.userRepo.findUserByEmailAndPassword(userDto.getEmail(), userDto.getPassword());

        if (user.isPresent()) {
            this.loggedInUser = user.get();
        } else {
            return INCORRECT_USERNAME_OR_PASSWORD;
        }

        return String.format(SUCCESSFULLY_LOGGED_IN, user.get().getFullName());
    }

    @Override
    public String logout() {
        if (this.loggedInUser == null) {
            return NO_USER_LOGGED_IN;
        }

        String userName = this.loggedInUser.getFullName();
        this.loggedInUser = null;
        return String.format(SUCCESSFULLY_LOG_OUT, userName);
    }

    @Override
    public boolean isLoggedInUserAdmin() {
        return this.loggedInUser != null && this.loggedInUser.isAdmin();
    }

    @Override
    public User getLoggedInUser() {
        return this.loggedInUser;
    }

    @Override
    public String addGameInShoppingCard(String title) {
        Game game = this.gameRepo.getGameByTitle(title);
        if (!this.loggedInUser.isHasGame(game) && !this.loggedInUser.isHasGameInShoppingCard(game)) {
            this.loggedInUser.getShoppingCard().add(game);
            return String.format(SUCCESSFULLY_ADDED_TO_CARD, game.getTitle());
        } else {
            return USER_HAS_GAME;
        }
    }

    @Override
    public String removeGameFromShoppingCard(String title) {
        Game game = this.gameRepo.getGameByTitle(title);
        if (this.loggedInUser.removeGameFromCard(game)) {
            return String.format(SUCCESSFULLY_REMOVED_FROM_CARD, game.getTitle());
        }
        return String.format(NOT_EXIST_GAME_IN_CARD, game.getTitle());
    }

    @Override
    public String buyGame() {
        StringBuilder out = new StringBuilder(SUCCESSFULLY_BOUGHT_GAMES)
                .append(System.lineSeparator());
        Order order = new Order(loggedInUser);
        List<Game> shoppingCard = this.loggedInUser.getShoppingCard();
        for (int i = 0; i < shoppingCard.size(); i++) {
            Game game = shoppingCard.get(i);
            out.append(String.format("- %s", game.getTitle())).append(System.lineSeparator());
            this.loggedInUser.removeGameFromCard(game);
            this.loggedInUser.getGames().add(game);
            order.getGames().add(game);
            i--;
        }
        if (!order.getGames().isEmpty()) {
            this.orderRepo.save(order);
            return out.toString().trim();
        }
        return NOT_BOUGHT_GAMES;
    }

    @Override
    public String getOwedGames() {
        if (this.loggedInUser.getGames().isEmpty()) {
            return NOT_GAMES_AVAILABLE;
        }
        StringBuilder out = new StringBuilder();
        for (Game game : this.loggedInUser.getGames()) {
            out.append(game.getTitle()).append(System.lineSeparator());
        }
        return out.toString().trim();
    }

}
