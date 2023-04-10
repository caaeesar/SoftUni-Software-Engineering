package PBExams.Exam25And26Jun22;

import java.util.Scanner;

public class ANDProcessors {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int processors = Integer.parseInt(scanner.nextLine());
        int staffs = Integer.parseInt(scanner.nextLine());
        int workDays = Integer.parseInt(scanner.nextLine());


        int workHours = staffs * 8 * workDays;
        double madeProcessors = Math.floor(workHours / 3.00);

        if (madeProcessors >= processors) {
            double profit = (madeProcessors - processors) * 110.10;
            System.out.printf("Profit: -> %.2f BGN", profit);
        } else {
            double losses = (processors - madeProcessors) * 110.10;
            System.out.printf("Losses: -> %.2f BGN", losses);

        }

    }
}
