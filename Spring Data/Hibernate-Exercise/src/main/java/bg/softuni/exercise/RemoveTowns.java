package bg.softuni.exercise;

import bg.softuni.entity.Address;
import bg.softuni.entity.Employee;
import bg.softuni.entity.Town;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Scanner;

import static bg.softuni.common.messages.Output.REMOVE_ADDRESS_FORMAT;
import static bg.softuni.common.messages.Propm.ENTER_TOWN_NAME;

public class RemoveTowns extends Exercise {
    @Override
    public String execute(EntityManager entityManager) {
        System.out.println(ENTER_TOWN_NAME);
        String townName = new Scanner(System.in).nextLine();

        Town town = entityManager.createQuery("FROM Town WHERE name = :tName", Town.class)
                .setParameter("tName", townName)
                .getSingleResult();

        setEmployeeAddressToNull(entityManager, townName);
        int affectedRows = removeAddressesByTownId(entityManager, town.getId());

        return String.format(REMOVE_ADDRESS_FORMAT, affectedRows, townName);
    }

    private int removeAddressesByTownId(EntityManager entityManager, Integer id) {
        entityManager.getTransaction().begin();
        List<Address> addresses = entityManager.createQuery("FROM Address WHERE town.id = :tId", Address.class)
                .setParameter("tId", id)
                .getResultList();

        addresses.forEach(entityManager::remove);
        entityManager.getTransaction().commit();
        entityManager.close();
        return addresses.size();
    }

    private void setEmployeeAddressToNull(EntityManager entityManager, String townName) {
        entityManager.getTransaction().begin();
        List<Employee> employees = entityManager.createQuery("FROM Employee AS e WHERE e.address.town.name = :tName", Employee.class)
                                                .setParameter("tName", townName)
                                                .getResultList();
        for (Employee employee : employees) {
            employee.setAddress(null);
            entityManager.persist(employee);
        }
        entityManager.getTransaction().commit();
    }
}
