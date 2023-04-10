package PBExams.Exam17Decembre17;

import java.util.Scanner;

public class SeasonSale {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String modelCar = scanner.nextLine();
        String typeCar = scanner.nextLine();
        String season = scanner.nextLine();
        String means = scanner.nextLine();
        double price = Double.parseDouble(scanner.nextLine());
        double desiredProfit = Double.parseDouble(scanner.nextLine());
        double currentProfit = 0.00;

        switch (typeCar) {

            case "suv":

                switch (means) {

                    case "perfect":
                        currentProfit = price * 0.30;
                        break;
                    case "good":
                        currentProfit = price * 0.20;
                        break;
                    case "bad":
                        currentProfit = price * 0.1;
                        break;
                }
                break;
            case "sedan":

                switch (means) {

                    case "perfect":
                        currentProfit = price * 0.25;
                        break;
                    case "good":
                        currentProfit = price * 0.15;
                        break;
                    case "bad":
                        currentProfit = price = 0.1;
                        break;
                }
                break;
        }
        switch (season) {
            case "winter":
                currentProfit -= 200;
                break;
        }
        if (currentProfit >= desiredProfit) {
            System.out.printf("The profit on %s will be good - %.2f BGN", modelCar, currentProfit);
        } else {
            System.out.println("The car is not worth selling now");
            System.out.printf("Need %.2f more profit", desiredProfit - currentProfit);
        }
    }
}
