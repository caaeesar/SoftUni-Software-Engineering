package ForLoop.moreExercise;

import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double inheritance = Double.parseDouble(scanner.nextLine());
        int lastYear = Integer.parseInt(scanner.nextLine());
        int currentAge = 18;


        for (int year = 1800; year <= lastYear; year++) {

            // in 1800 he is 18 years yet

            if (year % 2 == 0) {
                inheritance -= 12000;
            } else {
                double spendMoney = 12000 + (50 * currentAge);
                inheritance -= spendMoney;
            }
            // увеличаваме годините след като свърши настоящата годината, затова променливата е най-отдолу !!!!!
            currentAge ++;
        }
        boolean isEnough = inheritance >= 0;
        if (isEnough) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.",inheritance);
        } else {
            System.out.printf("He will need %.2f dollars to survive.",Math.abs(inheritance));
        }

    }
}
