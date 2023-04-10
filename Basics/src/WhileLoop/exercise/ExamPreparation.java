package WhileLoop.exercise;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int badGrades = Integer.parseInt(scanner.nextLine());
        boolean isEnough = false;
        int gradesCount = 0;
        double gradesSum = 0.00;
        int countBadGrades = 0;
        String lastTask = "";

        while (countBadGrades < badGrades) {

            String currentTask = scanner.nextLine();

            if (currentTask.equals("Enough")) {
                isEnough = true;
                break;
            }
            int currentGrades = Integer.parseInt(scanner.nextLine());

            if (currentGrades <= 4) {
                countBadGrades++;
            }
            gradesCount++;
            gradesSum += currentGrades;
            lastTask = currentTask;
        }
        if (isEnough) {
            System.out.printf("Average score: %.2f\n", gradesSum / gradesCount);
            System.out.printf("Number of problems: %d\n", gradesCount);
            System.out.printf("Last problem: %s", lastTask);
        } else {
            System.out.printf("You need a break, %d poor grades.", countBadGrades);
        }
    }
}
