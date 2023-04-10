package DataTypesAndVariables.lab;

import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int meters = Integer.parseInt(scanner.nextLine());
        double kilometres = meters / 1000.00;
        System.out.printf("%.2f", kilometres);
    }
}
