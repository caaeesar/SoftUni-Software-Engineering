package bg.softuni.exercise;

import bg.softuni.entity.Employee;
import bg.softuni.entity.Project;

import javax.persistence.EntityManager;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static bg.softuni.common.messages.Propm.ENTER_EMPLOYEE_ID;

public class GetEmployeesWithProject extends Exercise {

    @Override
    public String execute(EntityManager entityManager) {
        System.out.println(ENTER_EMPLOYEE_ID);
        int searchId = new Scanner(System.in).nextInt();

        Employee employee = entityManager.createQuery("FROM Employee WHERE id = :employeeId", Employee.class)
                                         .setParameter("employeeId", searchId)
                                         .getSingleResult();

        Set<Project> allProjects = employee.getProjects();
        Set<String> orderedProjectsName = allProjects.stream().map(Project::getName).collect(Collectors.toCollection(TreeSet::new));

        StringBuilder out = new StringBuilder();
        out.append(employee).append(System.lineSeparator());
        orderedProjectsName.forEach(pName -> out.append("      ").append(pName).append(System.lineSeparator()));

        return out.toString().trim();
    }
}
