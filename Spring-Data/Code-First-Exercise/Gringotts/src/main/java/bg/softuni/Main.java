package bg.softuni;

import bg.softuni.entity.Deposit;
import bg.softuni.entity.MagicWand;
import bg.softuni.entity.Wizard;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gringotts");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        MagicWand magicWand = new MagicWand();
        Deposit deposit1 = new Deposit();
        Deposit deposit2 = new Deposit();
        Wizard wizard = new Wizard("Melissa", 20);

        wizard.setMagicWand(magicWand);
        wizard.setDeposits(List.of(deposit1,deposit2));

        entityManager.persist(magicWand);
        entityManager.persist(deposit1);
        entityManager.persist(deposit2);
        entityManager.persist(wizard);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
