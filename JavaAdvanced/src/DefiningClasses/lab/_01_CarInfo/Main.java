package DefiningClasses.lab._01_CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Car currentCar = null;
        String brand;
        String model;
        int hp;

        while (n-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");
            brand = tokens[0];
            if (tokens.length == 1) {
                currentCar = new Car(brand);
            } else {
                model = tokens[1];
                hp = Integer.parseInt(tokens[2]);
                currentCar = new Car(brand, model, hp);

            }
            System.out.println(currentCar);
        }
    }
}
