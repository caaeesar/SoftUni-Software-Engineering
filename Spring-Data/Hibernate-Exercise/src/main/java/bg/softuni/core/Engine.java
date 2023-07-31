package bg.softuni.core;

import bg.softuni.common.Exercises;
import bg.softuni.exercise.*;

import javax.persistence.EntityManager;
import java.util.Scanner;


import static bg.softuni.common.messages.Error.INVALID_EX_NAME;
import static bg.softuni.common.messages.Propm.ENTER_EX_NAME;

public class Engine implements Runnable {

    private EntityManager entityManager;
    private final Scanner scanner = new Scanner(System.in);
    private Exercise exercise;
    private String output;
    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void run() {
        exercise = readExercise(scanner);
        if (exercise == null) {
            throw new IllegalArgumentException(INVALID_EX_NAME);
        }
        this.output = exercise.execute(entityManager);
        printOutput();
    }

    private Exercise readExercise(Scanner scanner) {
        System.out.println(ENTER_EX_NAME);
        String name = scanner.nextLine();

        if (Exercises.ChangeCasing.name().equals(name)) {
            return new ChangeCasing();
        } else if (Exercises.ContainsEmployee.name().equals(name)) {
            return new ContainsEmployee();
        } else if (Exercises.EmployeesWithASalaryOver50000.name().equals(name)) {
            return new EmployeesWithASalaryOver50000();
        } else if (Exercises.EmployeesFromDepartment.name().equals(name)) {
            return new EmployeesFromDepartment();
        } else if (Exercises.AddingANewAddressAndUpdatingTheEmployee.name().equals(name)) {
            return new AddingANewAddressAndUpdatingTheEmployee();
        } else if (Exercises.AddressesWithEmployeeCount.name().equals(name)) {
            return new AddressesWithEmployeeCount();
        } else if (Exercises.GetEmployeesWithProject.name().equals(name)) {
            return new GetEmployeesWithProject();
        } else if (Exercises.FindTheLatest10Projects.name().equals(name)) {
            return new FindTheLatest10Projects();
        } else if (Exercises.IncreaseSalaries.name().equals(name)) {
            return new IncreaseSalaries();
        } else if (Exercises.FindEmployeesByFirstName.name().equals(name)) {
            return new FindEmployeesByFirstName();
        } else if (Exercises.EmployeesMaximumSalaries.name().equals(name)) {
            return new EmployeesMaximumSalaries();
        } else if (Exercises.RemoveTowns.name().equals(name)) {
            return new RemoveTowns();
        }
        return null;
    }

    private void printOutput(){
        System.out.println(this.output);
    }

}
