package Polymorphism.exercises.Vehicles;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static final String CAR_NAME = "Car";
    public static final String TRUCK_NAME = "Truck";
    public static final String BUS_NAME = "Bus";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        //Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));

        String[] truckInfo = scanner.nextLine().split("\\s+");
        // Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(carInfo[3]));

        String[] busInfo = scanner.nextLine().split("\\s+");
        //Vehicle bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(carInfo[3]));

        Map<String, Vehicle> vehiclesByName = new LinkedHashMap<>();
        vehiclesByName.put(CAR_NAME, new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3])));
        vehiclesByName.put(TRUCK_NAME, new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3])));
        vehiclesByName.put(BUS_NAME, new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3])));

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            String[] parts = scanner.nextLine().split("\\s+");
            String command = parts[0];
            String vehicleName = parts[1];
            Vehicle vehicle = vehiclesByName.get(vehicleName);
            try {
                switch (command) {
                    case "DriveEmpty":
                        Bus bus = (Bus) vehiclesByName.get(BUS_NAME);
                        bus.setEmptyState();
                    case "Drive":
                        Double travelledKm = vehicle.driving(Double.parseDouble(parts[2]));
                        if (travelledKm != null) {
                            DecimalFormat df = new DecimalFormat("###.##");
                            System.out.println(vehicleName + " travelled " + df.format(travelledKm) + " km");
                        } else {
                            System.out.println(vehicleName + " needs refueling");
                        }
                        break;
                    case "Refuel":
                        vehicle.refueling(Double.parseDouble(parts[2]));
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        // process(parts, command, vehicle);
       /* System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);*/
        System.out.println("Car: " + String.format("%.2f", vehiclesByName.get(CAR_NAME).getFuelQuantity()));
        System.out.println("Truck: " + String.format("%.2f", vehiclesByName.get(TRUCK_NAME).getFuelQuantity()));
        System.out.println("Bus: " + String.format("%.2f", vehiclesByName.get(BUS_NAME).getFuelQuantity()));
    }

   /* private static void process(String[] parts, String command, Vehicle vehicle) {
        double distance;
        try {
            switch (command) {

          case "DriveEmpty":
                Bus bus = (Bus) vehicle;
                distance = Double.parseDouble(parts[2]);
                bus.setEmptyState();
                System.out.println(bus.driving(distance));

            case "Drive":
                if (vehicle instanceof Bus) {
                     ((Bus) vehicle).setNotEmptyState();
                }
                distance = Double.parseDouble(parts[2]);
                System.out.println(vehicle.driving(distance));
                break;

                case "Refuel":
                    double liters = Double.parseDouble(parts[2]);
                    vehicle.refueling(liters);

                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/
}



