package ObjectsAndClasses.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students2 {

    static class Student {

        private String firstName;
        private String lastName;
        private int age;
        private String hometown;

        Student(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

        public String getHometown() {
            return this.hometown;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }

        public boolean isStudentExist(List<Student> allStudents, String firstName, String lastName) {
            for (Student student : allStudents) {
                if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                    return true;
                }
            }
            return false;
        }

        public static Student getStudent(List<Student> allStudents, String firstName, String lastName) {
            Student existStudent = null;
            for (Student student : allStudents) {
                if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                    existStudent = student;
                }
            }
            return existStudent;
        }

        @Override
        public String toString() {
            return this.firstName + " " + this.lastName + " is " + this.age + " years old";
        }
    }

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<Student> allStudents = new ArrayList<>();

        while (!input[0].equals("end")) {

            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            String hometown = input[3];

            Student student = new Student(firstName, lastName, age, hometown);

            if (student.isStudentExist(allStudents, firstName, lastName)) {
                Student existStudent = Student.getStudent(allStudents, firstName, lastName);
                existStudent.setAge(age);
                existStudent.setHometown(hometown);
            } else {
                allStudents.add(student);
            }
            input = scanner.nextLine().split(" ");
        }
        String cityName = scanner.nextLine();

        for (Student currentStudent : allStudents) {

            if (currentStudent.getHometown().equals(cityName)) {
                System.out.println(currentStudent);
            }
        }
    }
}
