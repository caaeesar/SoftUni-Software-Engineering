package bg.softuni.exercise;

import bg.softuni.entity.Address;

import javax.persistence.EntityManager;
import java.util.List;


public class AddressesWithEmployeeCount extends Exercise {

    @Override
    public String execute(EntityManager entityManager) {
        StringBuilder out = new StringBuilder();

      List<Address> firstTenAddresses = entityManager
              .createQuery("FROM Address AS a ORDER BY a.employees.size DESC", Address.class)
              .setMaxResults(10)
              .getResultList();

      firstTenAddresses.forEach(a -> out.append(a)
              .append(System.lineSeparator()));


        return out.toString().trim();
    }
}
