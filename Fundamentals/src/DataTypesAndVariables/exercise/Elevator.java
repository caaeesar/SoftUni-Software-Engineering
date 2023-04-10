package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        double courses = Math.ceil(people * 1.00 / capacity);
        System.out.printf("%.0f", courses);
    }
}
