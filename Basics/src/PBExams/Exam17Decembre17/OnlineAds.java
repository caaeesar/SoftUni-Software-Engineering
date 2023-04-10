package PBExams.Exam17Decembre17;

import java.util.Scanner;

public class OnlineAds {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int allCars = Integer.parseInt(scanner.nextLine());
        String category = "";
        double gasoline = 0.00;
        double diesel = 0.00;

        for (int currentCar = 1; currentCar <= allCars; currentCar++) {

            String modelCar = scanner.nextLine();
            String typeCar = scanner.nextLine();
            String fuel = scanner.nextLine();
            String status = scanner.nextLine();
            double price = Double.parseDouble(scanner.nextLine());
            long kilometre = Long.parseLong(scanner.nextLine());

            if ("coupe".equals(typeCar) && "gasoline".equals(fuel) && price > 100_000) {
                category = "supersport";
                gasoline++;
            } else if ("coupe".equals(typeCar) && "gasoline".equals(fuel)){
                category = "sport";
                gasoline++;
            }
            if ("coupe".equals(typeCar) && "diesel".equals(fuel)) {
                category = "ecosport";
                diesel++;
            }
            if ("sedan".equals(typeCar) && "gasoline".equals(fuel) && price > 80_000) {
                category = "limousine";
                gasoline++;
            } else if ("sedan".equals(typeCar) && "gasoline".equals(fuel)){
                category = "executive";
                gasoline++;
            }
            if ("sedan".equals(typeCar) && "diesel".equals(fuel)) {
                category = "economic";
                diesel++;
            }

            switch (status) {
                case "vip":
                    price += 200;
                    break;
            }
            System.out.printf("Car model - %s%n", modelCar);
            System.out.printf("Category - %s%n", category);
            System.out.printf("Type - %s%n", typeCar);
            System.out.printf("Fuel - %s%n", fuel);
            System.out.printf("Kilometres - %s%n", kilometre);
            System.out.printf("Price - %.2f%n", price);
        }
        System.out.printf("Gasoline cars: %.2f%%%n", (gasoline / allCars) * 100);
        System.out.printf("Diesel cars: %.2f%%", (diesel / allCars) * 100);
    }
}
