package ForLoop.moreExercise;

import java.util.Scanner;

public class Grades {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        double allGrades = 0.00;
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;

        for (int i = 1; i <= students; i++) {
            double currentGrade = Double.parseDouble(scanner.nextLine());
            allGrades += currentGrade;

            if (currentGrade >= 2.00 && currentGrade <= 2.99) {
                ++countD;
            } else if (currentGrade <= 3.99) {
                ++countC;
            } else if (currentGrade <= 4.99) {
                ++countB;
            } else if (currentGrade >= 5.00) {
                ++countA;
            }
        }

        double percent1 = (countA * 1.00 / students) * 100;
        double percent2 = (countB * 1.00 / students) * 100;
        double percent3 = (countC * 1.00 / students) * 100;
        double percent4 = (countD * 1.00 / students) * 100;
        double average = allGrades / students;

        System.out.printf("Top students: %.2f%%\n", percent1);
        System.out.printf("Between 4.00 and 4.99: %.2f%%\n", percent2);
        System.out.printf("Between 3.00 and 3.99: %.2f%%\n", percent3);
        System.out.printf("Fail: %.2f%%\n", percent4);
        System.out.printf("Average: %.2f", average);
    }
}
