package PBExams.RetakeExam2And3May19;

import java.util.Scanner;

public class Safari {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double litres = Double.parseDouble(scanner.nextLine());
        String day = scanner.nextLine();

        double totalSum = (litres * 2.10) + 100;

        switch (day) {

            case "Saturday":
                totalSum -= (totalSum * 0.1);
                break;
            case "Sunday":
                totalSum -= (totalSum * 0.2);
                break;
        }
        if (budget >= totalSum) {

            System.out.printf("Safari time! Money left: %.2f lv.", budget - totalSum);
        } else {
            System.out.printf("Not enough money! Money needed: %.2f lv.", totalSum - budget);
        }
    }
}
