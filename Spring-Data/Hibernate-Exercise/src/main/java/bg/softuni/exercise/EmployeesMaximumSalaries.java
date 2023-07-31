package bg.softuni.exercise;

import javax.persistence.EntityManager;

public class EmployeesMaximumSalaries extends Exercise{

    @Override
    public String execute(EntityManager entityManager) {
        StringBuilder out = new StringBuilder();
        entityManager.createQuery("SELECT department.name, MAX(salary) " +
                        "FROM Employee " +
                        "GROUP BY department.name " +
                        "HAVING max(salary) NOT BETWEEN 30000 AND 70000", Object[].class)
                .getResultList()
                .forEach(objects -> out.append(objects[0]).append(" ").append(objects[1])
                        .append(System.lineSeparator()));

        return out.toString().trim();
    }
}
