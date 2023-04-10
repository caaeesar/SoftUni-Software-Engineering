package Basic.lab;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int totalMinutes = (hours * 60) + minutes;
        int after30Minutes = totalMinutes + 30;
        int h = after30Minutes / 60;
        int m = after30Minutes % 60;

        if (m > 59) {
            h++;
            m -= 60;
        }
        if (h > 23) {
            h = 0;
        }
        System.out.printf("%d:%02d",h,m);
    }
}
