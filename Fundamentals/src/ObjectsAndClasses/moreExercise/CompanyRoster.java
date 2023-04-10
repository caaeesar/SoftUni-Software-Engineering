package ObjectsAndClasses.moreExercise;

import java.util.*;

public class CompanyRoster {

    static class Employee {

        private String name;
        private double salary;
        private String position;
        private String department;
        private String email;
        private int age;

        Employee(String name, double salary, String position, String department, String email, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;
        }

        Employee(String name, double salary, String position, String department) {
            this(name, salary, position, department, "n/a", -1);
        }

        public String getDepartment() {
            return this.department;
        }

        public double getSalary() {
            return this.salary;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
        }
    }

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int linesOfInfo = Integer.parseInt(scanner.nextLine());
        List<Employee> employeeList = new ArrayList<>();

        for (int currentLine = 1; currentLine <= linesOfInfo; currentLine++) {

            String[] information = scanner.nextLine().split(" ");
            String name = information[0];
            double salary = Double.parseDouble(information[1]);
            String position = information[2];
            String department = information[3];
            Employee worker = new Employee(name, salary, position, department);

            if (information.length == 5) { // email or age

                if (information[4].contains("@")) { // only email

                    String email = information[4];
                    worker.setEmail(email);

                } else { // only age

                    int age = Integer.parseInt(information[4]);
                    worker.setAge(age);

                }
            } else if (information.length == 6) { // both -> email and age

                String email = information[4];
                int age = Integer.parseInt(information[5]);
                worker.setEmail(email);
                worker.setAge(age);

            }
            employeeList.add(worker);
        }

        List<String> departmentList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            Employee currentWorker = employeeList.get(i);
            String department = currentWorker.getDepartment();
            departmentList.add(department);
        }
       //department,salary
        Map<String, Double> departmentSalary = new TreeMap<>();
        for (int i = 0; i < employeeList.size(); i++) {

            Employee worker = employeeList.get(i);
            String department = worker.getDepartment();
            double salary = worker.getSalary();

            if (!departmentSalary.containsKey(department)) {
                departmentSalary.put(department, salary);
            } else {
                double currentSalary = departmentSalary.get(department);
                departmentSalary.put(department, currentSalary + salary);
            }
        }

        // get department with max average salary
       /* double maxSalary = Double.MIN_EXPONENT;
        for (Double salary : departmentSalary.values()) {

            if (salary > maxSalary) {
                maxSalary = salary;
            }
        }*/
        String bestDepartment = "";
        double maxValueInMap = (Collections.max(departmentSalary.values()));  // This will return max value in the HashMap
        for (Map.Entry<String, Double> entry : departmentSalary.entrySet()) {  // Iterate through HashMap
            if (entry.getValue() == maxValueInMap) {
                bestDepartment = entry.getKey();
                // Get the key with max value
            }
        }

        // sort salary in descending order:
        List<Double> salaries = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            double currentSalary = employeeList.get(i).getSalary();
            salaries.add(currentSalary);
        }
        Collections.sort(salaries);
        Collections.reverse(salaries);
        List<Employee> sortedEmployeeBySalary = new ArrayList<>();

        int index = 0;
        int indexSalary = 0;
        while (!employeeList.isEmpty()) {
            Employee worker = employeeList.get(index);

            if (worker.getSalary() == salaries.get(indexSalary)) {
                sortedEmployeeBySalary.add(worker);
                employeeList.remove(worker);
                indexSalary++;
                index = 0;
            } else {
                index++;
            }
        }

        System.out.printf("Highest Average Salary: %s%n", bestDepartment);
        for (int i = 0; i < sortedEmployeeBySalary.size(); i++) {

            Employee worker = sortedEmployeeBySalary.get(i);
            if (worker.getDepartment().equals(bestDepartment)) {
                System.out.println(worker);
            }
        }
    }
}
