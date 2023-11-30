package bg.softuni.springdataintro.service.imp;

import bg.softuni.springdataintro.entity.Account;
import bg.softuni.springdataintro.entity.User;
import bg.softuni.springdataintro.exception.EntityDoesNotExist;
import bg.softuni.springdataintro.exception.InvalidAccountOperationException;
import bg.softuni.springdataintro.repository.AccountRepository;
import bg.softuni.springdataintro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    // @Autowired field injection
    private AccountRepository accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public void createUserAccount(User user, Account account) {
        user.setAccounts(Set.of(account));
        account.setUser(user);
        accountRepo.save(account);
    }

    @Override
    public void withdrawMoney(Long accountId, BigDecimal amount) {
        Account account = accountRepo.findById(accountId).orElseThrow(() ->
                new EntityDoesNotExist(String.format("Entity with: %d id does not exist.", accountId)));
        if (account.getBalance().compareTo(amount) < 0) {
            throw new InvalidAccountOperationException(String.format("Error withdrawing amount: %s.", amount));
        }
        account.setBalance(account.getBalance().subtract(amount));
    }

    @Override
    public void depositMoney(Long accountId, BigDecimal amount) {
        Account account = accountRepo.findById(accountId).orElseThrow(() ->
                new EntityDoesNotExist(String.format("Entity with: %d id does not exist.", accountId)));
        account.setBalance(account.getBalance().add(amount));
    }

    @Override
    public void transferMoney(BigDecimal amount, Long fromAccountId, Long toAccountId) {
        withdrawMoney(fromAccountId,amount);
        depositMoney(toAccountId, amount);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }


}
