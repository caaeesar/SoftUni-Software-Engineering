package bg.softuni.exercise;

import bg.softuni.entity.Employee;

import javax.persistence.EntityManager;

import java.util.Scanner;

import static bg.softuni.common.messages.Propm.ENTER_EMPLOYEE_NAME;

public class ContainsEmployee extends Exercise{

    @Override
    public String execute(EntityManager entityManager) {
        System.out.println(ENTER_EMPLOYEE_NAME);
        String[] fullName = new Scanner(System.in).nextLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        entityManager.getTransaction().begin();

       String isPresent = entityManager.createQuery("SELECT e " +
                        "FROM Employee as e " +
                "WHERE e.firstName = :fName AND e.lastName = :lName", Employee.class)
                 .setParameter("fName", firstName)
                 .setParameter("lName", lastName)
                .getResultList()
                 .isEmpty() ? "No" : "Yes";

        entityManager.getTransaction().commit();
        entityManager.close();

        return isPresent;
    }
}
