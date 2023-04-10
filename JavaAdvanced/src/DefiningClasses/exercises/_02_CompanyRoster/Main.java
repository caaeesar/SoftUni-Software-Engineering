package DefiningClasses.exercises._02_CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Department> allDepartments = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {

            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String departmentName = data[3];
            String email;
            int age;

            Department department = new Department(departmentName);
            allDepartments.putIfAbsent(departmentName, department);


            if (data.length == 6) { // all data
                email = data[4];
                age = Integer.parseInt(data[5]);
                Employee employee = new Employee(name, salary, position, departmentName, email, age);
                addEmployeeInDepartmentList(allDepartments, employee);

            } else if (data.length == 5) {

                if (data[4].contains("@")) {
                    email = data[4];
                    Employee employee = new Employee(name, salary, position, departmentName, email);
                    addEmployeeInDepartmentList(allDepartments, employee);
                } else {
                    age = Integer.parseInt(data[4]);
                    Employee employee = new Employee(name, salary, position, departmentName, age);
                    addEmployeeInDepartmentList(allDepartments, employee);
                }

            } else if (data.length == 4) { // only mandatory
                Employee employee = new Employee(name, salary, position, departmentName);
                addEmployeeInDepartmentList(allDepartments, employee);
            }
        }
        Department bestDepartment = getDepartmentWithHighestSalary(allDepartments);
        System.out.printf("Highest Average Salary: %s\n", bestDepartment.getName());
        bestDepartment
                .getEmployeeList()
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);
    }

    private static Department getDepartmentWithHighestSalary(Map<String, Department> allDepartments) {
        double highestSalary = -1;
        double totalSalary = 0.00;
        Department bestDepartment = null;

        for (var department : allDepartments.entrySet()) {

            List<Employee> employeeList = department.getValue().getEmployeeList();
            for (Employee employee : employeeList) {
                totalSalary += employee.getSalary();
            }
            double currentAverage = totalSalary / employeeList.size();

            if (currentAverage > highestSalary) {
                highestSalary = currentAverage;
                bestDepartment = department.getValue();
            }
            totalSalary = 0.00;
        }
        return bestDepartment;
    }

    private static void addEmployeeInDepartmentList(Map<String, Department> allDepartments, Employee employee) {
        for (var department : allDepartments.entrySet()) {
            if (department.getValue().getName().equals(employee.getDepartment())) {
                department.getValue().addEmployee(employee);
            }
        }
    }
}
