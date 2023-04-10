package JavaBook;

import java.util.Scanner;

public class DailyEarnings {
    public static void main(String[] arguments){
        Scanner scanner = new Scanner(System.in);

        int workingDay = Integer.parseInt(scanner.nextLine());  // в един месец
        double moneyHour = Double.parseDouble(scanner.nextLine()); // изкарани пари (долари) на ден
        double currencyRate = Double.parseDouble(scanner.nextLine());   // курсът на долара спрямо лева

        double monthSalary = workingDay * moneyHour;
        double annualSalary = monthSalary * 12;
        double bonus = monthSalary * 2.5;
        double salaryBonus = annualSalary + bonus;
        double tax = salaryBonus * 0.25;
        double leftMoney = salaryBonus - tax;
        double moneyToLv = leftMoney * currencyRate;
        double averageProfit = moneyToLv / 365; //средната печалба на ден в лева

        System.out.printf("%.2f",averageProfit);
    }
}
