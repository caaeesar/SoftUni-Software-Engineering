package ObjectsAndClasses.moreExercise.rawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int linesOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> allCars = new ArrayList<>(linesOfCars);
        for (int currentLine = 1; currentLine <= linesOfCars; currentLine++) {

            //input
            String[] carInfo = scanner.nextLine().split("\\s");
            String model = carInfo[0];
            int engineSpeed = Integer.parseInt(carInfo[1]);
            int enginePower = Integer.parseInt(carInfo[2]);
            int cargoWeight = Integer.parseInt(carInfo[3]);
            String cargoType = carInfo[4];
            double tire1Pressure = Double.parseDouble(carInfo[5]);
            int tire1Age = Integer.parseInt(carInfo[6]);
            double tire2Pressure = Double.parseDouble(carInfo[7]);
            int tire2Age = Integer.parseInt(carInfo[8]);
            double tire3Pressure = Double.parseDouble(carInfo[9]);
            int tire3Age = Integer.parseInt(carInfo[10]);
            double tire4Pressure = Double.parseDouble(carInfo[11]);
            int tire4Age = Integer.parseInt(carInfo[12]);

            //create object
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);
            List<Tire> tires = new ArrayList<>();
            tires.add(tire1);
            tires.add(tire2);
            tires.add(tire3);
            tires.add(tire4);

            Car car = new Car(model, engine, cargo, tires);
            allCars.add(car);
        }


        String searchCargoType = scanner.nextLine();

        for (Car currentCar : allCars) {

            if (searchCargoType.equals("fragile")) {
                if (currentCar.getCargo().getType().equals(searchCargoType)) {

                    boolean areValidPressure = false;
                    List<Tire> fourTires = currentCar.getTires();
                    for (Tire currentTire : fourTires) {
                        if (currentTire.getPressure() < 1) {
                            areValidPressure = true;
                            break;
                        }
                    }
                    if (areValidPressure) {
                        System.out.println(currentCar);
                    }
                }
            } else if (searchCargoType.equals("flamable")) {
                if (currentCar.getCargo().getType().equals(searchCargoType)) {

                    if (currentCar.getEngine().getPower() > 250) {
                        System.out.println(currentCar);
                    }
                }
            }
        }
    }
}
