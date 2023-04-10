package ObjectsAndClasses.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {

    static class Vehicle {

        private String type;
        private String model;
        private String colour;
        private int horsepower;
        static int countCar;
        static int countTruck;
        static double totalCarHP = 0.00;
        static double totalTruckHP = 0.00;

        Vehicle(String type, String model, String colour, int horsepower) {
            this.type = type;
            if (this.type.equals("car")) {
                ++countCar;
                totalCarHP += horsepower;
            } else {
                ++countTruck;
                totalTruckHP += horsepower;
            }
            this.model = model;
            this.colour = colour;
            this.horsepower = horsepower;
        }

        public String getModel() {
            return this.model;
        }

        @Override
        public String toString() {
            if (this.type.equals("car")) {
                this.type = "Car";
            } else {
                this.type = "Truck";
            }
            return String.format("Type: %s%n" +
                            "Model: %s%n" +
                            "Color: %s%n" +
                            "Horsepower: %d",
                    this.type, this.model, this.colour, this.horsepower);
        }
    }

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> allVehicles = new ArrayList<>();
        String command1 = scanner.nextLine();

        while (!"End".equals(command1)) {

            String[] information = command1.split(" ");
            String type = information[0];
            String model = information[1];
            String colour = information[2];
            int horsepower = Integer.parseInt(information[3]);

            Vehicle vehicle = new Vehicle(type, model, colour, horsepower);
            allVehicles.add(vehicle);
            command1 = scanner.nextLine();
        }

        String command2 = scanner.nextLine();

        while (!"Close the Catalogue".equals(command2)) {

            for (int i = 0; i < allVehicles.size(); i++) {

                String currentModel = command2;
                Vehicle currentVehicle = allVehicles.get(i);

                if (currentVehicle.getModel().equals(currentModel)) {
                    System.out.println(currentVehicle);
                }
            }
            command2 = scanner.nextLine();
        }

        double averageCarHP = Vehicle.totalCarHP / Vehicle.countCar;
        double averageTruckHP = Vehicle.totalTruckHP / Vehicle.countTruck;
        if (Vehicle.totalTruckHP == 0.00) { // todo NaN
            averageTruckHP = 0.00;
        }
        if (Vehicle.totalCarHP == 0.00) {
            averageCarHP = 0.00;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageCarHP);
        System.out.printf("Trucks have average horsepower of: %.2f.", averageTruckHP);

    }
}
