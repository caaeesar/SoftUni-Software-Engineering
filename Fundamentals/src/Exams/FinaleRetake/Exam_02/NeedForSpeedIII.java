package Exams.FinaleRetake.Exam_02;

import java.util.*;

public class NeedForSpeedIII {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> collectionCars = new LinkedHashMap<>();

        for (int currentLine = 1; currentLine <= numberOfCars; currentLine++) {

            String[] inputCarInfo = scanner.nextLine().split("\\|");

            String carModel = inputCarInfo[0];
            int mileage = Integer.parseInt(inputCarInfo[1]);
            int fuel = Integer.parseInt(inputCarInfo[2]);

            collectionCars.put(carModel, new ArrayList<>());
            List<Integer> currentCarDate = collectionCars.get(carModel);
            currentCarDate.add(0, mileage);
            currentCarDate.add(1, fuel);
        }

        String input = scanner.nextLine();
        while (!"Stop".equals(input)) {

            String[] parts = input.split(" : ");
            String command = parts[0];
            String carModel = parts[1];
            int fuel;
            List<Integer> currentCarDate = collectionCars.get(carModel);
            int currentMileage = currentCarDate.get(0);
            int currentFuel = currentCarDate.get(1);

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(parts[2]);
                    fuel = Integer.parseInt(parts[3]);

                    if (currentFuel < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        currentFuel -= fuel;
                        currentMileage += distance;
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n",
                                carModel, distance, fuel);

                        if (currentMileage >= 100_000) {
                            System.out.printf("Time to sell the %s!\n", carModel);
                            collectionCars.remove(carModel);
                            input = scanner.nextLine();
                            continue;
                        }
                    }
                    break;
                case "Refuel":
                    fuel = Integer.parseInt(parts[2]);
                    if (currentFuel + fuel >= 75) {
                        fuel = 75 - currentFuel;
                        currentFuel = 75;
                    } else {
                        currentFuel += fuel;
                    }
                    System.out.printf("%s refueled with %d liters\n", carModel, fuel);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(parts[2]);
                    currentMileage -= kilometers;

                    if (currentMileage >= 10_000) {
                        System.out.printf("%s mileage decreased by %d kilometers\n", carModel, kilometers);
                    }
                    if (currentMileage < 10_000) {
                        currentMileage = 10_000;
                    }
                    break;
            }
            currentCarDate = new ArrayList<>();
            currentCarDate.add(0, currentMileage);
            currentCarDate.add(1, currentFuel);
            collectionCars.put(carModel, currentCarDate);
            input = scanner.nextLine();
        }
        collectionCars.forEach((key, value) -> {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n",
                    key, value.get(0), value.get(1));
        });
    }
}
