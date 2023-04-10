package DataTypesAndVariables.moreExercise;

import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());

        if (Math.abs(a - b) < 0.000001) {
            System.out.print("True");
        } else {
            System.out.print("False");
        }
    }
}
