package bg.softuni.springdataintro.service;

import bg.softuni.springdataintro.entity.Account;
import bg.softuni.springdataintro.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    void createUserAccount(User user, Account account);
    void withdrawMoney(Long accountId, BigDecimal amount);
    void depositMoney(Long accountId, BigDecimal amount);
    void transferMoney(BigDecimal amount, Long fromAccountId, Long toAccountId);
    List<Account> getAllAccounts();
}
