package ObjectsAndClasses.moreExercise.companyRoster;

import java.util.*;

public class Main {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Employee> employeeList = new ArrayList<>();
        Map<String, Double> departmentsTotalSalaries = new HashMap<>();
        Map<String, Integer> departmentWorkers = new HashMap<>();
        Map<String,Double> departmentAverageSalary = new HashMap<>();

        int lines = Integer.parseInt(scanner.nextLine());
        for (int currentLine = 1; currentLine <= lines; currentLine++) {

            String[] information = scanner.nextLine().split(" ");
            String name = information[0];
            double salary = Double.parseDouble(information[1]);
            String position = information[2];
            String department = information[3];
            String email = "n/a";
            int age = -1;
            if (information.length == 5) {
                if (Arrays.toString(information).contains("@")) {
                    email = information[4];
                } else {
                    age = Integer.parseInt(information[4]);
                }
            } else if (information.length == 6){
                email = information[4];
                age = Integer.parseInt(information[5]);
            }

            Employee currentEmployee = new Employee(name, salary, position, department, email, age);
            employeeList.add(currentEmployee);

            Integer countWorkers = departmentWorkers.get(department);
            if (!departmentWorkers.containsKey(department)) {
                departmentWorkers.put(department,1);
            } else {
                departmentWorkers.put(department,countWorkers + 1);
            }

            Double currentTotalSalary = departmentsTotalSalaries.get(department);
            if (!departmentsTotalSalaries.containsKey(department)) {
                departmentsTotalSalaries.put(department, salary);
            } else {
                departmentsTotalSalaries.put(department, currentTotalSalary + salary);
            }
        }

        for (Map.Entry<String, Double> entry : departmentsTotalSalaries.entrySet()) {

            String currentDepartment = entry.getKey();
            double averageSalary  = entry.getValue() / departmentWorkers.get(currentDepartment);
            departmentAverageSalary.putIfAbsent(currentDepartment,averageSalary);
        }

        String bestDepartment = "";
        double maxAverageSalary = Collections.max(departmentAverageSalary.values());

        for (Map.Entry<String, Double> entry : departmentAverageSalary.entrySet()) {
            if (entry.getValue() == maxAverageSalary) {
                bestDepartment = entry.getKey();
            }
        }

        List<Employee> workersInBestDep = new ArrayList<>();
        for (Employee worker : employeeList) {
            if (worker.getDepartment().equals(bestDepartment)) {
                workersInBestDep.add(worker);
            }
        }

        System.out.printf("Highest Average Salary: %s\n",bestDepartment);
      workersInBestDep.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);

    }
}
