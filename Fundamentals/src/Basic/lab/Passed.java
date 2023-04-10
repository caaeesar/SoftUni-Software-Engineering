package Basic.lab;

import java.util.Scanner;

public class Passed {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());
        if (grade >= 3.00) {
            System.out.print("Passed!");
        }
    }
}
