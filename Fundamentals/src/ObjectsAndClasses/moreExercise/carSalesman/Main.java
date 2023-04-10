package ObjectsAndClasses.moreExercise.carSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> allEngines = new ArrayList<>();
        int linesOfEngines = Integer.parseInt(scanner.nextLine());
        for (int currentLine = 1; currentLine <= linesOfEngines; currentLine++) {

            String[] engineInfo = scanner.nextLine().split("\\s");
            String model = engineInfo[0];
            int power = Integer.parseInt(engineInfo[1]);
            String displacement = "n/a";
            String efficiency = "n/a";

            if (engineInfo.length == 3) {
                String str = engineInfo[2];
                char[] charsArr = str.toCharArray();
                if (Character.isDigit(charsArr[0])) {
                    displacement = engineInfo[2];
                } else {
                    efficiency = engineInfo[2];
                }
            } else if (engineInfo.length == 4) {
                displacement = engineInfo[2];
                efficiency = engineInfo[3];
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            allEngines.add(engine);
        }

        int linesOfCars = Integer.parseInt(scanner.nextLine());
        for (int currentLine = 1; currentLine <= linesOfCars; currentLine++) {

            String[] carInfo = scanner.nextLine().split("\\s");
            String model = carInfo[0];
            String engineModel = carInfo[1];
            String weight = "n/a";
            String color = "n/a";

            if (carInfo.length == 3) {
                char c = carInfo[2].charAt(0);
                if (Character.isDigit(c)) {
                    weight = carInfo[2];
                } else {
                    color = carInfo[2];
                }
            } else if (carInfo.length == 4) {
                weight = carInfo[2];
                color = carInfo[3];
            }
            Engine engine = null;
            for (Engine currentEngine : allEngines) {
                if (currentEngine.getModel().equals(engineModel)) {
                    engine = currentEngine;
                }
            }
            Car car = new Car(model, engine, weight, color);
            System.out.println(car);
        }

    }
}
