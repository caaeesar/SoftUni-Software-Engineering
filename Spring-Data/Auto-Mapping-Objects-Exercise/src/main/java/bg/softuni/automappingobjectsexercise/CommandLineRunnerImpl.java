package bg.softuni.automappingobjectsexercise;

import bg.softuni.automappingobjectsexercise.enums.Command;
import bg.softuni.automappingobjectsexercise.model.dto.game.GameAddDto;
import bg.softuni.automappingobjectsexercise.model.dto.user.UserLoginDto;
import bg.softuni.automappingobjectsexercise.model.dto.user.UserRegisterDto;
import bg.softuni.automappingobjectsexercise.service.GameService;
import bg.softuni.automappingobjectsexercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final Scanner scanner;
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public CommandLineRunnerImpl(Scanner scanner, UserService userService, GameService gameService) {
        this.scanner = scanner;
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) {
        System.out.println("Enter command and parameters:");
        String[] data = Arrays.stream(scanner.nextLine().split("\\|")).toArray(String[]::new);

        while (true) {

            switch (Command.valueOf(data[0])) {
                case RegisterUser -> System.out.println(this.userService.registerUser(new UserRegisterDto(data[1], data[2], data[3], data[4])));
                case LoginUser -> System.out.println(this.userService.loginUser(new UserLoginDto(data[1], data[2])));
                case Logout -> System.out.println(this.userService.logout());
                case AddGame -> System.out.println(this.gameService.addGame(new GameAddDto(
                                                                            data[1],
                                                                            BigDecimal.valueOf(Double.parseDouble(data[2])),
                                                                            Double.parseDouble(data[3]),
                                                                            data[4],
                                                                            data[5],
                                                                            data[6],
                                                                            data[7])));
                case EditGame -> System.out.println(this.gameService.editGame(data));
                case DeleteGame -> System.out.println(this.gameService.deleteGame(Long.parseLong(data[1])));
                case AllGames -> this.gameService.getAllGames().forEach(System.out::println);
                case DetailGame -> System.out.println(this.gameService.getGameInfo(data[1]));
                case AddItem -> System.out.println(this.userService.addGameInShoppingCard(data[1]));
                case RemoveItem -> System.out.println(this.userService.removeGameFromShoppingCard(data[1]));
                case BuyItem -> System.out.println(this.userService.buyGame());
                case OwnedGames -> System.out.println(this.userService.getOwedGames());

            }
            data = Arrays.stream(scanner.nextLine().split("\\|")).toArray(String[]::new);
        }
    }
}
