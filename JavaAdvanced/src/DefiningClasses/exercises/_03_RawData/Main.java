package DefiningClasses.exercises._03_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Car> allCarList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {

            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];

            int speed = Integer.parseInt(data[1]);
            int power = Integer.parseInt(data[2]);
            Engine engine = new Engine(speed, power);

            int weight = Integer.parseInt(data[3]);
            String type = data[4];
            Cargo cargo = new Cargo(weight, type);

            List<Tire> tiresList = new ArrayList<>();
            double pressure1 = Double.parseDouble(data[5]);
            int age1 = Integer.parseInt(data[6]);
            Tire tire1 = new Tire(pressure1, age1);
            tiresList.add(tire1);

            double pressure2 = Double.parseDouble(data[7]);
            int age2 = Integer.parseInt(data[8]);
            Tire tire2 = new Tire(pressure2, age2);
            tiresList.add(tire2);

            double pressure3 = Double.parseDouble(data[9]);
            int age3 = Integer.parseInt(data[10]);
            Tire tire3 = new Tire(pressure3, age3);
            tiresList.add(tire3);

            double pressure4 = Double.parseDouble(data[11]);
            int age4 = Integer.parseInt(data[12]);
            Tire tire4 = new Tire(pressure4, age4);
            tiresList.add(tire4);

            Car car = new Car(model, engine, cargo, tiresList);
            allCarList.add(car);
        }

        String searchCargoType = scanner.nextLine();
        switch (searchCargoType) {
            case "fragile":

                for (Car car : allCarList) {
                    if (car.getCargo().getType().equals("fragile")) {
                        if (car.isValidPressures()) {
                            System.out.println(car);
                        }
                    }
                }
                break;
            case "flamable":

                for (Car car : allCarList) {
                    if (car.getCargo().getType().equals("flamable")) {
                        if (car.isValidEngine()) {
                            System.out.println(car);
                        }
                    }
                }
                break;
        }
    }
}
