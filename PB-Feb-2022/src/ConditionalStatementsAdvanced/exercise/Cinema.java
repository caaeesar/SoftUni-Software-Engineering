package ConditionalStatementsAdvanced.exercise;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String projection = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        int totalHall = rows * columns;
        double premiere = 12.00;
        double normal = 7.50;
        double discount = 5.00;

        double result = 0.00;

        switch (projection) {
            case "Premiere":
                result = totalHall * premiere;
                break;
            case "Normal":
                result = totalHall * normal;
                break;
            case "Discount":
                result = totalHall * discount;
                break;
        }
        System.out.printf("%.2f leva",result);
    }
}
