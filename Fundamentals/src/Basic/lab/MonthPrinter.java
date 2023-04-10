package Basic.lab;

import java.util.Scanner;

public class MonthPrinter {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int month = Integer.parseInt(scanner.nextLine());
        String[] months = {
                "January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October",
                "November", "December"
        };

        switch (month) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                System.out.print(months[month - 1]);
                break;
            default:
                System.out.print("Error!");
                break;
        }
    }
}
