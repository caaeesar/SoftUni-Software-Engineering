package DefiningClasses.exercises._04_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> allEnginesList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {

            String[] engineData = scanner.nextLine().split("\\s+");
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            Engine engine = new Engine(model, power);
            ;

            if (engineData.length == 3) {

                if (Character.isLetter(engineData[2].charAt(0))) {
                    String efficiency = engineData[2];
                    engine.setEfficiency(efficiency);
                } else {
                    String displacement = engineData[2];
                    engine.setDisplacement(displacement);
                }

            } else if (engineData.length == 4) {
                String displacement = engineData[2];
                engine.setDisplacement(displacement);
                String efficiency = engineData[3];
                engine.setEfficiency(efficiency);
            }
            allEnginesList.add(engine);
        }


        n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {

            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            String searchModel = carData[1];
            Engine engine = null;

            for (Engine currentEngine : allEnginesList) {
                if (currentEngine.getModel().equals(searchModel)) {
                    engine = currentEngine;
                }
            }

            Car car = new Car(model, engine);

            if (carData.length == 3) {

                if (Character.isLetter(carData[2].charAt(0))) {
                    String color = carData[2];
                    car.setColor(color);
                } else {
                    String weight = carData[2];
                    car.setWeight(weight);
                }

            } else if (carData.length == 4) {
                String weight = carData[2];
                car.setWeight(weight);
                String color = carData[3];
                car.setColor(color);
            }
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngine());
            System.out.printf("Weight: %s\n", car.getWeight());
            System.out.printf("Color: %s\n", car.getColor());
        }
    }
}
