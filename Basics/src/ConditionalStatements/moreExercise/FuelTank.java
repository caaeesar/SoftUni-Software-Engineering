package ConditionalStatements.moreExercise;

import java.util.Locale;
import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String typeFuel = scan.nextLine();
        double fuelLitres = Double.parseDouble(scan.nextLine());

        if (fuelLitres >= 25) {
            switch (typeFuel) {
                case "Diesel":
                case "Gasoline":
                case "Gas":
                    System.out.printf("You have enough %s.", typeFuel.toLowerCase());
                    break;
                default:
                    System.out.println("Invalid fuel!");
                    break;
            }
        } else if (fuelLitres < 25) {
            switch (typeFuel) {
                case "Diesel":
                case "Gasoline":
                case "Gas":
                    System.out.printf("Fill your tank with %s!", typeFuel.toLowerCase());
                    break;
               default:
                    System.out.println("Invalid fuel!");
                    break;
            }
        }
    }
}
