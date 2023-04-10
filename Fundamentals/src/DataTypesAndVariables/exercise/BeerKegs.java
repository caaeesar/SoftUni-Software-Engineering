package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // double - min value
        int totalKegs = Integer.parseInt(scanner.nextLine());
        String bestModel = "";
        double maxVolume = Double.NEGATIVE_INFINITY;

        for (int currentKegs = 1; currentKegs <= totalKegs; currentKegs++) {

            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            double currentVolume = Math.PI * (Math.pow(radius,2)) * height;

            if (currentVolume > maxVolume) {
                maxVolume = currentVolume;
                bestModel = model;
            }
        }
        System.out.printf("%s", bestModel);
    }
}
