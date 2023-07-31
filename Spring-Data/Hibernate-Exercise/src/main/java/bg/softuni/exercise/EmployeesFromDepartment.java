package bg.softuni.exercise;

import bg.softuni.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

import static bg.softuni.common.messages.Output.EMPLOYEE_DEPARTMENT_SALARY_FORMAT;

public class EmployeesFromDepartment extends Exercise{

    private static final String SEARCH_DEPARTMENT = "Research and Development";

    @Override
    public String execute(EntityManager entityManager) {
        entityManager.getTransaction().begin();

       List<Employee> employeeList = entityManager
               .createQuery("FROM Employee AS e WHERE department.name = :dName " +
                            "ORDER BY salary ASC, id ASC", Employee.class)
               .setParameter("dName", SEARCH_DEPARTMENT)
               .getResultList();

       StringBuilder out = new StringBuilder();
       employeeList.forEach(e -> out.append(String.format(EMPLOYEE_DEPARTMENT_SALARY_FORMAT,
               e.getFirstName(),e.getLastName(),e.getDepartment().getName(),e.getSalary()))
               .append(System.lineSeparator()));

        entityManager.getTransaction().commit();
        entityManager.close();

        return out.toString().trim();
    }
}
