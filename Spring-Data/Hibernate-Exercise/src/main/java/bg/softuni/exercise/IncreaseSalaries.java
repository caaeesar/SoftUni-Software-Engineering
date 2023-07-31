package bg.softuni.exercise;

import bg.softuni.entity.Employee;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

import static bg.softuni.common.messages.Output.EMPLOYEE_NAME_SALARY_FORMAT;

public class IncreaseSalaries extends Exercise {

    @Override
    public String execute(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        List<Employee> employeeList = entityManager.createQuery("FROM Employee WHERE department.name IN (:d1,:d2,:d3,:d4)", Employee.class)
                .setParameter("d1", "Engineering")
                .setParameter("d2", "Tool Design")
                .setParameter("d3", "Marketing")
                .setParameter("d4", "Information Services")
                .getResultList();

        employeeList.forEach(e -> e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12))));

        StringBuilder out = new StringBuilder();
        employeeList.forEach(e -> out.append(String.format(EMPLOYEE_NAME_SALARY_FORMAT, e.getFirstName(), e.getLastName(), e.getSalary()))
                                    .append(System.lineSeparator()));

        entityManager.getTransaction().commit();
        entityManager.close();

        return out.toString().trim();
    }
}
