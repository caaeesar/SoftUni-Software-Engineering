package DefiningClasses.exercises._03_SpeedRacing;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Car> allCarList = new LinkedList<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {

            String[] carData = scanner.nextLine().split("\\s");
            String model = carData[0];
            double fuelAmount = Double.parseDouble(carData[1]);
            double fuelCostFor1km = Double.parseDouble(carData[2]);

            Car car = new Car(model, fuelAmount, fuelCostFor1km);
            allCarList.add(car);
        }

        String input = scanner.nextLine();
        while (!"End".equals(input)) {

            String searchModel = input.split("\\s")[1];
            int amountOfKm = Integer.parseInt(input.split("\\s")[2]);

            for (Car car : allCarList) {

                if (car.getModel().equals(searchModel)) {

                    double totalKmCost = car.getTotalKmCost(amountOfKm);
                    if (car.canMove(totalKmCost)) {

                        car.decreasingFuelAmount(totalKmCost);
                        car.increasingDistance(amountOfKm);
                    } else {
                        System.out.println("Insufficient fuel for the drive");
                    }
                }
            }
            input = scanner.nextLine();
        }
        allCarList.forEach(System.out::println);
    }
}
