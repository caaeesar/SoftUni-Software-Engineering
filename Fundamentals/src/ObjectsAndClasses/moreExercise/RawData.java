package ObjectsAndClasses.moreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RawData {

    static class Car {

        private String model;
        private Engine engine;
        private Cargo cargo;
        private List<Tire> tires;

        public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tires = tires;
        }

        public boolean checkPressure() {
            for (int tireIndex = 0; tireIndex < this.tires.size(); tireIndex++) {
                double currentPressure = this.tires.get(tireIndex).getPressure();
                if (currentPressure < 1) {
                    return true;
                }
            }
            return false;
        }

        public boolean checkPower() {
            if (this.engine.getPower() < 250) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return this.model;
        }
    }

    static class Engine {

        private int speed;
        private int power;

        Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }

        public int getPower() {
            return this.power;
        }
    }

    static class Cargo {

        private int weight;
        private String type;

        Cargo(int weight, String type) {
            this.weight = weight;
            this.type = type;
        }

        public String getType() {
            return this.type;
        }
    }

    static class Tire {

        private double pressure;
        private int age;

        Tire(double pressure, int age) {
            this.pressure = pressure;
            this.age = age;
        }

        public double getPressure() {
            return this.pressure;
        }
    }

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int currentLine = 0; currentLine < lines; currentLine++) {

            String[] parts = scanner.nextLine().split(" ");
            String model = parts[0];

            int speed = Integer.parseInt(parts[1]);
            int power = Integer.parseInt(parts[2]);
            Engine engine = new Engine(speed, power);

            int weight = Integer.parseInt(parts[3]);
            String type = parts[4];
            Cargo cargo = new Cargo(weight, type);

            List<Tire> tires = new ArrayList<>();
            double pressure1 = Double.parseDouble(parts[5]);
            int age1 = Integer.parseInt(parts[6]);
            Tire tire1 = new Tire(pressure1, age1);
            tires.add(tire1);

            double pressure2 = Double.parseDouble(parts[7]);
            int age2 = Integer.parseInt(parts[8]);
            Tire tire2 = new Tire(pressure2, age2);
            tires.add(tire2);

            double pressure3 = Double.parseDouble(parts[9]);
            int age3 = Integer.parseInt(parts[10]);
            Tire tire3 = new Tire(pressure3, age3);
            tires.add(tire3);

            double pressure4 = Double.parseDouble(parts[11]);
            int age4 = Integer.parseInt(parts[12]);
            Tire tire4 = new Tire(pressure4, age4);
            tires.add(tire4);

            Car car = new Car(model, engine, cargo, tires);
            carList.add(car);
        }

        String cargoType = scanner.nextLine();
        for (int carIndex = 0; carIndex < carList.size(); carIndex++) {
            String currentCargoType = carList.get(carIndex).cargo.getType();

            switch (cargoType) {
                case "fragile":
                    if (currentCargoType.equals(cargoType)) {

                        if (carList.get(carIndex).checkPressure()) {
                            System.out.println(carList.get(carIndex));
                        }
                    }
                    break;
                case "flamable":

                    if (carList.get(carIndex).checkPower()) {
                        System.out.println(carList.get(carIndex));
                    }
                    break;
            }
        }
    }
}
