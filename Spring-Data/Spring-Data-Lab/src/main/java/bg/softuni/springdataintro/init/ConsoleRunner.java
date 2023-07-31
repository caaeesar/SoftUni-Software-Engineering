package bg.softuni.springdataintro.init;

import bg.softuni.springdataintro.entity.Account;
import bg.softuni.springdataintro.entity.User;
import bg.softuni.springdataintro.service.AccountService;
import bg.softuni.springdataintro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private UserService userService;
    private AccountService accountService;

    @Autowired
    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {

        // Add users and accounts
        User user1 = new User("Melissa");
        this.userService.register(user1);
        Account account1 = new Account(new BigDecimal(1000));
        this.accountService.createUserAccount(user1, account1);

        User user2 = new User("George");
        this.userService.register(user2);
        Account account2 = new Account(new BigDecimal(2000));
        this.accountService.createUserAccount(user2, account2);

        // withdraw money with invalid amount
        this.accountService.withdrawMoney(account2.getId(), new BigDecimal(3000)); // error

        // withdraw money with valid amount
        this.accountService.withdrawMoney(account2.getId(), new BigDecimal(100));

        // deposit
        this.accountService.depositMoney(account2.getId(), new BigDecimal(100));

        // transfer
        this.accountService.transferMoney(new BigDecimal(500), account2.getId(), account1.getId());



    }
}
