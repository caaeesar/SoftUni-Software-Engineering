package Basic.lab;

import java.util.Scanner;

public class StudentInformation {

    static class Student {
        private String name;
        private int age;
        private double grade;

        Student(String name, int age, double grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        public String getName() {
            return this.name;
        }

        public int getAge() {
            return this.age;
        }

        public double getGrade() {
            return this.grade;
        }
    }

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Student student = new Student(scanner.nextLine(), scanner.nextInt(), scanner.nextDouble());
        System.out.printf("Name: %s, Age: %d, Grade: %.2f", student.getName(), student.getAge(), student.getGrade());
    }
}
