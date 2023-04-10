package ConditionalStatements.exercise;

import java.util.Scanner;

public class BonusScore {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int startPoints = Integer.parseInt(scanner.nextLine());
        double bonus = 0.00;     // само бонус точките, които получава числото
        double totalSum = 0.00; // бонуса + точките

        if (startPoints <= 100) {
            bonus = 5;
        } else if (startPoints > 1000) {
            bonus = startPoints * 0.1;
        } else {
            bonus = startPoints * 0.2;   //бонус точките са 20% от числото
        }
        if (startPoints % 2 == 0) {
            bonus += 1;
        } else if (startPoints % 10 == 5) {
            bonus += 2;
        }

        totalSum = startPoints + bonus;
        System.out.printf("%.1f%n%.1f",bonus,totalSum);
    }
}
