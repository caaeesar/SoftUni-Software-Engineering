package Exams.Mid.Exam_03;

import java.util.Scanner;

public class BonusScoringSystem {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int allStudents = Integer.parseInt(scanner.nextLine());
        int allLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        double maxBonus = 0.00;
        int maxAttendances = 0;

        for (int currentLine = 0; currentLine < allStudents; currentLine++) {

            int studentAttendances = Integer.parseInt(scanner.nextLine());
            double totalBonus = ((1.0 * studentAttendances / allLectures) * (5 + additionalBonus));

            if (totalBonus >= maxBonus) {
                maxBonus = totalBonus;
                maxAttendances = studentAttendances;
            }
        }
        System.out.printf("Max Bonus: %.0f.\n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %.0f lectures.", Math.ceil(maxAttendances));
    }
}
