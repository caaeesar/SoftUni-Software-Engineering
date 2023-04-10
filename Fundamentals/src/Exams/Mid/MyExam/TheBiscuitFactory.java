package Exams.Mid.MyExam;

import java.util.Scanner;

public class TheBiscuitFactory {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int biscuitsPerDay = Integer.parseInt(scanner.nextLine());
        int totalWorkers = Integer.parseInt(scanner.nextLine());
        int productionOfOtherFac = Integer.parseInt(scanner.nextLine());

        int countDay = 0;
        double totalProduction = 0.00;
        double usualProduction = biscuitsPerDay * totalWorkers;

        for (int day = 1; day <= 30; day++) {

            countDay++;
            if (countDay == 3) {
                double thirdDayProduction = Math.floor(usualProduction * 0.75);
                totalProduction += thirdDayProduction;
                countDay = 0;
            } else {
                totalProduction += usualProduction;
            }
        }
        System.out.printf("You have produced %.0f biscuits for the past month.\n", totalProduction);
        if (totalProduction > productionOfOtherFac) {
            double diff = totalProduction - productionOfOtherFac;
            double percentage = (diff / productionOfOtherFac) * 100;
            System.out.printf("You produce %.2f percent more biscuits.\n", percentage);
        } else if (productionOfOtherFac > totalProduction) {
            double diff = productionOfOtherFac - totalProduction;
            double percentage = (diff / productionOfOtherFac) * 100;
            System.out.printf("You produce %.2f percent less biscuits.", percentage);
        }
    }
}
