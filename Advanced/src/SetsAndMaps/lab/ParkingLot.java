package SetsAndMaps.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while (!"END".equals(input)) {

            String directions = input.split(",\\s+")[0];
            String carNumber = input.split(",\\s+")[1];

            switch (directions) {
                case "IN":
                    parking.add(carNumber);
                    break;
                case "OUT":
                    parking.remove(carNumber);
                    break;
            }
            input = scanner.nextLine();
        }
        if (parking.isEmpty()) {
            System.out.print("Parking Lot is Empty");
        } else {
            for (String currentCarNumber : parking) {
                System.out.println(currentCarNumber);
            }
        }
    }
}
