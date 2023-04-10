package Arrays.lab;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday", "Sunday"};

        int dayNumber = Integer.parseInt(scanner.nextLine());
        if (dayNumber <= 0 || dayNumber > 7) {
            System.out.print("Invalid day!");
        } else {
            System.out.print(daysOfWeek[dayNumber - 1]);
        }
    }
}
