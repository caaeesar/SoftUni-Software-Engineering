package bg.softuni.exercise;

import bg.softuni.entity.Employee;

import javax.persistence.EntityManager;


public class EmployeesWithASalaryOver50000 extends Exercise {

    @Override
    public String execute(EntityManager entityManager) {
        StringBuilder out = new StringBuilder();
        entityManager.createQuery("FROM Employee AS e WHERE e.salary > 50000", Employee.class)
                .getResultList()
                .forEach(e -> out.append(e.getFirstName()).append(System.lineSeparator()));

        return out.toString().trim();
    }
}
