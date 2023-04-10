package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        int totalLiters = 0;

        for (int currentLiters = 1; currentLiters <= lines; currentLiters++) {

            int quantity = Integer.parseInt(scanner.nextLine());

            if (capacity < quantity) {
                System.out.println("Insufficient capacity!");
            } else {
                capacity -= quantity;
                totalLiters += quantity;
            }
        }
        System.out.print(totalLiters);
    }
}
