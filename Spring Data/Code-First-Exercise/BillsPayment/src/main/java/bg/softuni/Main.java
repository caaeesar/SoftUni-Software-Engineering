package bg.softuni;

import bg.softuni.entity.BankAccount;
import bg.softuni.entity.CreditCard;
import bg.softuni.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("paymentSystem");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        User user = new User("Melissa", "1234");
        entityManager.persist(user);

        CreditCard card = new CreditCard(5, 2028);
        entityManager.persist(card);
        card.setOwner(user); // FK
        // user.setBillingDetails(List.of(card)); invalid relation,
        // because the FK is in billing_details table

        BankAccount account = new BankAccount();
        entityManager.persist(account);
        account.setOwner(user);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
