package bg.softuni.usersystem.init;

import bg.softuni.usersystem.entity.User;
import bg.softuni.usersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private UserService userService;

    @Autowired
    public CommandLineRunnerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        seedUsers();

        System.out.println("Enter email provider:");
        String emailProvider = scanner.nextLine();

        this.userService.getAllUsersWithEmailProvider(emailProvider).forEach(user -> System.out.println(user.getUsername()));

        int deleted = this.userService.removeInactiveUsers();
        System.out.printf("%d users was deleted", deleted);

    }

    private void seedUsers() {
        for (int i = 0; i < 15; i++) {
            User user = User.builder()
                    .username("username" + i)
                    .age(i)
                    .email("someone" + i + "@gmail.com")
                    .lastTimeLoggedIn(LocalDate.now())
                    .build();
            this.userService.register(user);
        }
    }
}
