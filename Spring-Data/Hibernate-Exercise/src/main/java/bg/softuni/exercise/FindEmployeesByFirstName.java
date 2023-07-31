package bg.softuni.exercise;

import bg.softuni.entity.Employee;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Scanner;

import static bg.softuni.common.messages.Output.EMPLOYEE_NAME_JOB_SALARY_FORMAT;
import static bg.softuni.common.messages.Propm.ENTER_NAME_PATTERN;

public class FindEmployeesByFirstName extends Exercise {

    @Override
    public String execute(EntityManager entityManager) {
        System.out.println(ENTER_NAME_PATTERN);
        String pattern = new Scanner(System.in).nextLine().toLowerCase();

        List<Employee> employeeList = entityManager.createQuery("FROM Employee WHERE LOWER(firstName) LIKE :p", Employee.class)
                .setParameter("p",pattern + "%")
                .getResultList();

        StringBuilder out = new StringBuilder();
        employeeList.forEach(e -> out.append(String.format(EMPLOYEE_NAME_JOB_SALARY_FORMAT,
                e.getFirstName(),e.getLastName(),e.getJobTitle(),e.getSalary()))
                .append(System.lineSeparator()));

        return out.toString().trim();
    }
}
