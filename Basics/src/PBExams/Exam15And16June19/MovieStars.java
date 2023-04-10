package PBExams.Exam15And16June19;

import java.util.Scanner;

public class MovieStars {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();
        boolean isEnough = true;

        while (!"ACTION". equals(command)) {

            String actorName = command;
            int length = actorName.length();

            if (length > 15) {
                budget -= (budget * 0.2);
            } else {
                double salary = Double.parseDouble(scanner.nextLine());
                budget -= salary;
            }

            if (budget <= 0) {
                isEnough = false;
                break;
            }
            command = scanner.nextLine();
        }
        if (isEnough) {
            System.out.printf("We are left with %.2f leva.", budget);
        } else {
            System.out.printf("We need %.2f leva for our actors.", Math.abs(budget));
        }
    }
}
