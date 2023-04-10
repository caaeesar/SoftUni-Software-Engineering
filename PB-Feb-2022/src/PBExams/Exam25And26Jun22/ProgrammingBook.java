package PBExams.Exam25And26Jun22;

import java.util.Scanner;

public class ProgrammingBook {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double pricePage = Double.parseDouble(scanner.nextLine());
        double priceCover = Double.parseDouble(scanner.nextLine());
        int percentDiscount = Integer.parseInt(scanner.nextLine());
        double sumDesigner = Double.parseDouble(scanner.nextLine());
        int percentStaff = Integer.parseInt(scanner.nextLine());

        double sum = (pricePage * 899) + (priceCover * 2);
        double withoutDiscount = sum - (sum * (percentDiscount / 100.00));
        double totalSum = withoutDiscount + sumDesigner;

        double result = totalSum - (totalSum * (percentStaff / 100.00));

        System.out.printf("Avtonom should pay %.2f BGN.", result);

    }
}
