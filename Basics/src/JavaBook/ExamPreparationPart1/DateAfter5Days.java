package JavaBook.ExamPreparationPart1;

import java.util.Scanner;

public class DateAfter5Days {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int day = Integer.parseInt(scanner.nextLine());
        int month = Integer.parseInt(scanner.nextLine());
        int totalDay = 0;

        switch (month) {

            case 4:
            case 6:
            case 9:
            case 11:
                totalDay = 30;
                break;

            case 2:
                totalDay = 28;
                break;

            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 12:
            case 10:
                totalDay = 31;
                break;

        }

        int after5days = day + 5;

        if (after5days <= totalDay) {
            System.out.printf("%d.%02d", day + 5, month);
        } else  {
            int diff = after5days - totalDay;
            day = 0;
            day += diff;
            if (month == 12) {
                month = 0;
            }
            month++;
            System.out.printf("%d.%02d", day, month);
        }
    }
}
