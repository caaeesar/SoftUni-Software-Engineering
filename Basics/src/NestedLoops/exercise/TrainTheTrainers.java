package NestedLoops.exercise;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int judges = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        double currentTotal = 0.00;
        double totalGrades = 0.00;
        int countGrades = 0;

        while (!input.equals("Finish")) {

            for (int grades = 1; grades <= judges; grades++) {

                double currentGrade = Double.parseDouble(scanner.nextLine());
                countGrades++;
                currentTotal += currentGrade; // сбора на оценките за една презентация
                totalGrades += currentGrade;

                if (grades == judges) {
                double averageForOne = currentTotal / judges; // средната оценка за една презентация
                System.out.printf("%s - %.2f.\n", input, averageForOne);
                currentTotal = 0.00;
                }
            }
            input = scanner.nextLine();
        }
        totalGrades = totalGrades / countGrades;
        System.out.printf("Student's final assessment is %.2f.", totalGrades);
    }
}
