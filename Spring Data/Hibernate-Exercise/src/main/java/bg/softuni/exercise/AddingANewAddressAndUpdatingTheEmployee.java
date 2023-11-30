package bg.softuni.exercise;

import bg.softuni.entity.Address;
import bg.softuni.entity.Employee;
import bg.softuni.entity.Town;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Scanner;

import static bg.softuni.common.messages.Output.EMPLOYEE_ADDRESS_FORMAT;
import static bg.softuni.common.messages.Propm.ENTER_EMPLOYEE_LAST_NAME;

public class AddingANewAddressAndUpdatingTheEmployee extends Exercise{

    public static final String NEW_ADDRESS_TEXT = "Vitoshka 15";

    @Override
    public String execute(EntityManager entityManager) {
        System.out.println(ENTER_EMPLOYEE_LAST_NAME);
        String lastName = new Scanner(System.in).nextLine();

        entityManager.getTransaction().begin();

        List<Employee> employeeList = entityManager.createQuery("FROM Employee AS e WHERE e.lastName = :lName", Employee.class)
                                                    .setParameter("lName", lastName)
                                                    .getResultList();

        Address address = new Address();
        address.setText(NEW_ADDRESS_TEXT);
        entityManager.persist(address);
        // set town
        Town Sofia = entityManager.find(Town.class, 32);
        address.setTown(Sofia);

        employeeList.forEach(e -> e.setAddress(address));

        StringBuilder out = new StringBuilder();
        employeeList.forEach(e -> out.append(String.format(EMPLOYEE_ADDRESS_FORMAT, e.getFirstName()))
                .append(System.lineSeparator()));

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();

        return out.toString().trim();
    }
}
