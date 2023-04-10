package PBExams.Exam6And7July19;

import java.util.Scanner;

public class Renovation {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int height = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        double percentNoPaint = Double.parseDouble(scanner.nextLine()) / 100;

        double totalArea = Math.ceil(height * width * 4.00);
        double areaForPaint = totalArea - (totalArea * percentNoPaint);

        String input = scanner.nextLine();

        while (!input.equals("Tired!")) {

            int currentLiters = Integer.parseInt(input);
            areaForPaint -= currentLiters;

            if (areaForPaint == 0) {

                System.out.print("All walls are painted! Great job, Pesho!");
                break;
            } else if (areaForPaint < 0) {

                System.out.printf("All walls are painted and you have %.0f l paint left!", Math.abs(areaForPaint));
                break;
            }
            input = scanner.nextLine();
        }

        if (input.equals("Tired!")) {
            System.out.printf("%.0f quadratic m left.", areaForPaint);
        }

    }
}
