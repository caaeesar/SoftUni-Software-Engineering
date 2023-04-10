package ObjectsAndClasses.exercise.vihicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicleList = new ArrayList<>();

        double countCarTypes = 0.00;
        double sumCarsHP = 0.00;
        double countTruckTypes = 0.00;
        double sumTrucksHP = 0.00;

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] dates = input.split(" ");

            Vehicle vehicle = new Vehicle
                    (dates[0], dates[1], dates[2], Integer.parseInt(dates[3]));

            if (vehicle.getType().equals("car")) {
                sumCarsHP += vehicle.getHorsepower();
                countCarTypes++;
                vehicle.setType("Car");
            } else { // truck
                sumTrucksHP += vehicle.getHorsepower();
                countTruckTypes++;
                vehicle.setType("Truck");
            }
            vehicleList.add(vehicle);
            input = scanner.nextLine();
        }

        String command = scanner.nextLine();
        while (!"Close the Catalogue".equals(command)) {
            String searchModel = command;

            for (Vehicle vehicle : vehicleList) {
                if (vehicle.getModel().equals(searchModel)) {
                    System.out.println(vehicle);
                }
            }
            command = scanner.nextLine();
        }
        double averageCarsHP = sumCarsHP / countCarTypes;
        double averageCTrucksHP = sumTrucksHP / countTruckTypes;
        if (sumCarsHP == 0.00 && countCarTypes == 0.00) {
            averageCarsHP = 0.00;
        }
        if (sumTrucksHP == 0.00 && countTruckTypes == 0.00) {
            averageCTrucksHP = 0.00;
        }
        System.out.printf("Cars have average horsepower of: %.2f.\n",
                averageCarsHP);
        System.out.printf("Trucks have average horsepower of: %.2f.",
                averageCTrucksHP);
    }
}
