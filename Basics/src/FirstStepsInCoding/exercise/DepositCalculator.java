package FirstStepsInCoding.exercise;

import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double deposit = Double.parseDouble(scan.nextLine());
        int term = Integer.parseInt(scan.nextLine());
        double annualRate = Double.parseDouble(scan.nextLine());

        double wholeRate = deposit * (annualRate / 100);
        double rateForMonth = wholeRate / 12; //изчислената лихва за тази сума, делим на 12, за да разберем лихвата за 1 месец;
        double result = deposit + (term * rateForMonth);

        System.out.println(result);

    }
}
