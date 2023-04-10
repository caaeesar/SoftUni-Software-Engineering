package PBExams.PreExam18And19June22;

import java.util.Scanner;

public class FinalCompetition {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int dancer = Integer.parseInt(scanner.nextLine());
        double points = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = scanner.nextLine();
        double money = 0.00;

        switch (place) {

            case "Bulgaria":
                money = points * dancer;

                switch (season) {
                    case "summer":
                        money -= (money * 0.05);
                        break;
                    case "winter":
                        money -= (money * 0.08);
                        break;
                }
                break;
            case "Abroad":
                money = (points * dancer) + ((points * dancer) * 0.5); // todo

                switch (season) {
                    case "summer":
                        money -= (money * 0.10);
                        break;
                    case "winter":
                        money -= (money * 0.15);
                        break;
                }
                break;
        }

        double raisedMoney = money * 0.75;

        double leftMoney = money - raisedMoney;

        double moneyForDancer = leftMoney / dancer;

        System.out.printf("Charity - %.2f%n", raisedMoney);
        System.out.printf("Money per dancer - %.2f", moneyForDancer);
    }
}
